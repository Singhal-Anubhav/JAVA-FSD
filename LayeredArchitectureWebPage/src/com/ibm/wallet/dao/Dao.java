package com.ibm.wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.wallet.bean.*;

public class Dao implements DaoInterface {
	
	Connection dbCon;
	PreparedStatement pstmt;
	PreparedStatement pstmt1;
	
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet?serverTimezone=IST", "root", "");
			System.out.println("Connected");
		} catch (SQLException e) {
			Bean b = new Bean();
			b.setException(e.getMessage());
			PrintException.problemConnection(b);
		}catch(ClassNotFoundException e) {
			Bean b = new Bean();
			b.setException(e.getMessage());
			PrintException.problemClass(b);
		}
	}
	
	@Override
	public int insertData(Bean b) {
		int n=0;
		String insertQuery = "insert into customer_details values(?,?,?,?,?)";
		String loginQuery = "insert into logindetails values(?,?)";
		try {
			pstmt = dbCon.prepareStatement(insertQuery);
			pstmt.setInt(2, b.getAccountNumber());
			pstmt.setDouble(3, b.getHolderContactNumber());
			pstmt.setString(4, b.getAadharNumber());
			pstmt.setString(1, b.getHolderName());
			pstmt.setInt(5, b.getAccountBalance());
			
			if(pstmt.executeUpdate()>0)
				n=n+1;	
			pstmt = dbCon.prepareStatement(loginQuery);
			pstmt.setDouble(1, b.getHolderContactNumber());
			pstmt.setString(2, b.getPassword());
			
			if(pstmt.executeUpdate()>0)
				n=n+1;
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemInserting(b);
		}
		return n;
	}
	
	@Override
	public int updateName(Bean b) {
		int n=0;
		String queryNameUpdate = "update customer_details set Name = ? where Account_Number =?";
		try {
			pstmt = dbCon.prepareStatement(queryNameUpdate);
			pstmt.setInt(2,b.getAccountNumber());
			pstmt.setString(1,b.getHolderName());
			
			if(pstmt.executeUpdate()>0)
				n=n+1;
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemUpdatingName(b);
		}
		return n;
	}

	@Override
	public int updateNumber(Bean b) {
		int n=0;
		String queryNumberUpdate = "update customer_details set Phone_Number = ? where Account_Number =?";
		try {
			pstmt = dbCon.prepareStatement(queryNumberUpdate);
			pstmt.setInt(2,b.getAccountNumber());
			pstmt.setDouble(1,b.getHolderContactNumber());
			
			if(pstmt.executeUpdate()>0)
				n=n+1;
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemUpdatingNumber(b);
		}
		return n;
	}

	@Override
	public Bean getBalance(Bean b) {
		String queryGetBalance = " select Balance from customer_details where Phone_Number = ?";
		
		try {
			pstmt = dbCon.prepareStatement(queryGetBalance);
			pstmt.setDouble(1, b.getHolderContactNumber());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
				b.setAccountBalance(rs.getInt("Balance"));
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemGettingBalance(b);
		}
		return b;
	}

	public boolean checkBalance(Bean b) {
		boolean t = false;
		String checkBalance = "select Balance from customer_details where Account_Number=?";
		String queryGetAccountNumber = "select Account_Number from customer_details where Phone_Number =?";
		try {
			pstmt = dbCon.prepareStatement(checkBalance);
			
			pstmt1 = dbCon.prepareStatement(queryGetAccountNumber);
			pstmt1.setDouble(1, b.getHolderContactNumber());
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()) {
				b.setAccountNumber(rs.getInt("Account_Number"));
			}
			pstmt.setInt(1, b.getAccountNumber());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt("Balance")>b.getTransctionAmount())
					t = true;
			}
		} catch (SQLException e ) {
			b.setException(e.getMessage());
			PrintException.problemCheckingBalance(b);
		}
		return t;
		
	}
	
	@Override
	public int depositInAccount(Bean b) {
		int flag=0;
		String queryDeposit = "insert into transaction_details(Account_Number,Amount,Transaction_Time) value (?,?,?)";
		
		String queryGetAccountNumber = "select Account_Number from customer_details where Phone_Number =?";
		
		String queryUpdateAccountBalance = "UPDATE customer_details SET Balance = Balance + ?  WHERE Account_Number = ?";
											
		try {
			pstmt = dbCon.prepareStatement(queryDeposit);
			pstmt.setInt(2, b.getTransctionAmount());
			pstmt.setDate(3, b.getTransactionTime());
			
			pstmt1 = dbCon.prepareStatement(queryGetAccountNumber);
			pstmt1.setDouble(1, b.getHolderContactNumber());
			ResultSet rs = pstmt1.executeQuery();
			if(rs.next()) {
				b.setAccountNumber(rs.getInt("Account_Number"));
			}
			pstmt.setInt(1, b.getAccountNumber());
			if(pstmt.executeUpdate()>0)
				flag=flag+1;
			
			pstmt = dbCon.prepareStatement(queryUpdateAccountBalance);
			pstmt.setInt(1, b.getTransctionAmount());
			pstmt.setInt(2, b.getAccountNumber());
			if(pstmt.executeUpdate()>0)
				flag=flag+1;
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemDepositing(b);
		}
		return flag;
	}

	public int withdrawFromAccount(Bean b) {
		int flag=0;
		String queryDeposit = "insert into Transaction_details(Account_Number,Amount,Transaction_Time) value (?,?,?)";
		
		String queryGetAccountNumber = "select Account_Number from customer_details where Phone_Number =?";
		
		String queryUpdateAccountBalance = "UPDATE customer_details SET Balance = Balance - ?  WHERE Account_Number = ?";
		if(checkBalance(b)) {								
		try {
			pstmt = dbCon.prepareStatement(queryDeposit);
			pstmt.setInt(2, -b.getTransctionAmount());
			pstmt.setDate(3, b.getTransactionTime());
			
			pstmt1 = dbCon.prepareStatement(queryGetAccountNumber);
			pstmt1.setDouble(1, b.getHolderContactNumber());
			ResultSet rs = pstmt1.executeQuery();
			if(rs.next()) {
				b.setAccountNumber(rs.getInt("Account_Number"));
			}
			pstmt.setInt(1, b.getAccountNumber());
			if(pstmt.executeUpdate()>0)
				flag=flag+1;
			
			pstmt = dbCon.prepareStatement(queryUpdateAccountBalance);
			pstmt.setInt(1, b.getTransctionAmount());
			pstmt.setInt(2, b.getAccountNumber());
			if(pstmt.executeUpdate()>0)
				flag=flag+1;
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemWithdrawing(b);
		}
		}
		else
			PrintException.printNoFunds(b);
		
		return flag;
	}
  
	public List<Bean> getTransaction(Bean b) {
		List<Bean> bilers = new ArrayList<Bean>();
		String queryGet = "select * from transaction_details where Account_Number=?";
		String getAcc = "select Account_Number from customer_details where Phone_Number = ?";
		
		int accNum = 0;
		
		try {
			pstmt1 = dbCon.prepareStatement(getAcc);
			pstmt1.setDouble(1, b.getHolderContactNumber());
			
			ResultSet rs1 = pstmt1.executeQuery();
			while(rs1.next()){
				accNum = rs1.getInt("Account_Number");
			}
			b.setAccountNumber(accNum);
			System.out.println(b.getAccountNumber());
			
			pstmt = dbCon.prepareStatement(queryGet);
			pstmt.setInt(1, b.getAccountNumber());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Bean b1 = new Bean();
				b1.setTransactionNumber(rs.getInt("Transaction_id"));
				b1.setAccountNumber(rs.getInt("Account_Number"));
				b1.setTransctionAmount(rs.getInt("Amount"));
				b1.setTransactionTime(rs.getDate("Transaction_Time"));
				bilers.add(b1);
			}
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemPrintingTransaction(b);
		}
		return bilers ;
	}
	
	public List<Bean> getAllData(Bean b) {
		List<Bean> bilers = new ArrayList<Bean>();
		String queryGet = "select * from customer_details where Phone_Number = ?";
		try {
			pstmt = dbCon.prepareStatement(queryGet);
			pstmt.setDouble(1, b.getHolderContactNumber());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Bean b1 = new Bean();
				b1.setAccountNumber(rs.getInt("Account_Number"));
				b1.setHolderName(rs.getString("Name"));
				b1.setHolderContactNumber(rs.getDouble("Phone_Number"));
				b1.setAccountBalance(rs.getInt("Balance"));
				b1.setAadharNumber("Aadhar_Number");
				bilers.add(b1);
			}
		} catch (SQLException e) {
			b.setException(e.getMessage());
			PrintException.problemPrintingData(b);
		}
		return bilers;
	}

	@Override
	public int checkPassword(Bean b) {
		int n=0;
		int m=0;
		String checkQuery = "select Phone_Number from login_details";
		String checkPassWord = "select password from login_details where Phone_Number=?";
		try {
			pstmt = dbCon.prepareStatement(checkQuery);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(b.getHolderContactNumber()==rs.getDouble("Phone_Number")) {
					n=n+1;
					m=m+1;
				}
			}
			pstmt = dbCon.prepareStatement(checkPassWord);
			pstmt.setDouble(1, b.getHolderContactNumber());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(b.getPassword().trim().equals(rs.getString("password")))
					n=n+1;
			}
			
		} catch (SQLException e) {
			System.out.println("Problem while checking" + e.getMessage());
		}
		return n;
	}
}