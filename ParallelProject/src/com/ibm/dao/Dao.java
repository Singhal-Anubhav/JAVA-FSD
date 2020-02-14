package com.ibm.dao;

import java.util.Scanner;
import com.ibm.dao.DaoInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.*;


public class Dao implements DaoInterface {
	
	Scanner scan = new Scanner(System.in);
    PreparedStatement pstmt;
    PreparedStatement pstmt1;
    PreparedStatement pstmt2;

	public Connection ServiceConnection(Connection dbCon) {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet?serverTimezone=UTC", "root", "");
		} catch (SQLException e) {
			System.out.println("problem while connection "  + e.getMessage());
		}
		return dbCon;
	}

	@Override
	public void insertCustomerDetails(Connection dbCon, String Name, double Phone_Number, String Aadhar_Number, int Balance) {
		// TODO Auto-generated method stub
		Random Account = new Random();
		String query = "insert into customer_details value(?,?,?,?,?)";
		try {
		pstmt = dbCon.prepareStatement(query);
		pstmt.setString(1,Name);
		pstmt.setInt(2, Account.nextInt(100000));
		pstmt.setDouble(3,Phone_Number);
		pstmt.setString(4,Aadhar_Number);
		pstmt.setInt(5, Balance);
		
		
		if(pstmt.executeUpdate()>0)
			System.out.println("Account  Created for " + Name);
		else
			System.out.println("Account not created....");
		} catch (SQLException e) {
			System.out.println("problem while inserting " + e.getMessage());
		}
	}
		

	@Override
	public void updateCustomerDetails(Connection dbCon,int n) {
		// TODO Auto-generated method stub
		String nameqry = "update customer_details set Name=? where Account_Number=?";
		String phnqry = "update customer_details set Phone_Number= ? where Account_Number= ?";
		String Aadharqry = "update customer_details set Aadhar_Number= ? where Account_Number= ?";
		
		switch(n) {
		case 1 :
			try {
		pstmt = dbCon.prepareStatement(nameqry);
		System.out.println("Enter the new Name ");
		String name = scan.nextLine();
		System.out.println("Enter the Customer Account Number  ");
		int number = scan.nextInt();
		scan.nextLine();
		pstmt.setInt(2, number);
		pstmt.setString(1, name);
		if(pstmt.executeUpdate()>0)
		System.out.println("Name updated");
		else 
		System.out.println("Name not  updated");
		} catch (SQLException e) {
		System.out.println("problem while updating salary" + e.getMessage());
		}
			break;
		case 2 :
			try {
				pstmt = dbCon.prepareStatement(phnqry);
				System.out.println("Enter the new Phone Number ");
				double num = scan.nextDouble();
				scan.nextLine();
				System.out.println("Enter the Customer Account Number  ");
				int number = scan.nextInt();
				scan.nextLine();
				pstmt.setInt(2, number);
				pstmt.setDouble(1, num);
				if(pstmt.executeUpdate()>0)
				System.out.println("Phone Number  updated");
				else 
				System.out.println("Phone Number not  updated");
				} catch (SQLException e) {
				System.out.println("problem while updating salary" + e.getMessage());
				}
			break;
		case 3 :
			try {
				pstmt = dbCon.prepareStatement(Aadharqry);
				System.out.println("Enter the new Aadhar Number ");
				String Aadhar = scan.nextLine();
				scan.nextLine();
				System.out.println("Enter the Customer Account Number  ");
				int number = scan.nextInt();
				scan.nextLine();
				pstmt.setInt(2, number);
				pstmt.setString(1, Aadhar);
				if(pstmt.executeUpdate()>0)
				System.out.println("Aadhar number  updated");
				else 
				System.out.println("Aadhar number not  updated");
				} catch (SQLException e) {
				System.out.println("problem while updating salary" + e.getMessage());
				}
			break;
		   default :
			break;	
		}
		
	}
		
		

	@Override
	public void moneyWithdrawal(Connection dbCon) {
		// TODO Auto-generated method stub
		System.out.println("Enter the amount to be Withdrawn");
		long amount = scan.nextLong();

		//scan.NextLine();

		System.out.println("Enter phone number");
		double phoneNumber = scan.nextDouble();


		String depositQry = "INSERT INTO transaction_details (Account_Number, Amount, Transaction_Time) VALUES (?,?,?)";

		String getAccountNumber = "SELECT Account_Number FROM customer_details WHERE Phone_Number = ?";

		String UpdateAccBalanceQry = "UPDATE customer_details "
		+ "SET customer_details.Balance = customer_details.Balance - ? WHERE Account_Number = ?";

		try {
		pstmt = dbCon.prepareStatement(depositQry);
		pstmt1 = dbCon.prepareStatement(getAccountNumber);

		pstmt1.setDouble(1, phoneNumber);
		ResultSet rs = pstmt1.executeQuery();
		rs.next();
		int accNum = rs.getInt("Account_Number");

		java.util.Date date = new java.util.Date();
		java.sql.Date date2 = new java.sql.Date(date.getTime());

		pstmt.setInt(1, accNum);
		pstmt.setLong(2,- amount);
		pstmt.setDate(3, date2);

		if(pstmt.executeUpdate() > 0)
		System.out.println("Transaction added..");
		else
		System.out.println("Transaction Not added");

		pstmt = dbCon.prepareStatement(UpdateAccBalanceQry);
		pstmt.setLong(1, amount);
		pstmt.setInt(2, accNum);

		if(pstmt.executeUpdate() > 0)
		System.out.println("Balance updated");
		else
		System.out.println("Balance not updated");

		} catch (SQLException e) {
		System.out.println("issue with withdrawl " + e.getMessage());
		}
		
		}

	@Override
	public void moneyDeposit(Connection dbCon) {
		// TODO Auto-generated method stub
		System.out.println("Enter the amount to be deposited");
		long amount = scan.nextLong();

		scan.nextLine();

		System.out.println("Enter phone number");
		double phoneNumber = scan.nextDouble();
		scan.nextLine();

		//inputString();

		String depositQry = "INSERT INTO transaction_details (Account_Number, Amount, Transaction_Time) VALUES (?,?,?)";

		String getAccountNumber = "SELECT Account_Number FROM customer_details WHERE Phone_Number = ?";

		String UpdateAccBalanceQry = "UPDATE customer_details "
		+ "SET customer_details.Balance = customer_details.Balance + ? WHERE Account_Number = ?";

		try {
		pstmt = dbCon.prepareStatement(depositQry);
		pstmt1 = dbCon.prepareStatement(getAccountNumber);

		pstmt1.setDouble(1, phoneNumber);
		ResultSet rs = pstmt1.executeQuery();
		rs.next();
		int accNum = rs.getInt("Account_Number");
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		java.sql.Date date2 = new java.sql.Date(date.getTime());

		//String time = getCurrentTime();

		pstmt.setInt(1, accNum);
		pstmt.setLong(2,+ amount);
		pstmt.setDate(3,date2);

		if(pstmt.executeUpdate() > 0)
		System.out.println("Transaction added..");
		else
		System.out.println("Transaction Not added");

		pstmt = dbCon.prepareStatement(UpdateAccBalanceQry);
		pstmt.setLong(1, amount);
		pstmt.setInt(2,accNum);

		if(pstmt.executeUpdate() > 0)
		System.out.println("Balance updated");
		else {
		System.out.println("Balance not updated");
		}
		} catch (SQLException e) {
		System.out.println("issue with deposit " + e.getMessage());
		}
		}


	@Override
	public void AccountToAccountTransfer(Connection dbCon) {
		// TODO Auto-generated method stub
		int accountNumber = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter transaction amount");
		int transactionAmount = scan.nextInt();
		java.util.Date d = new java.util.Date();
		java.sql.Date d1 = new java.sql.Date(d.getTime());
		System.out.println("Enter the withdarwers contact number");
		double holderContactNumber = scan.nextDouble();
		scan.nextLine();
		String checkBalance = "select Balance from customer_details where Account_Number=?";
		String queryGetAccountNumber = "select Account_Number from customer_Details where Phone_Number =?";

		try {
		pstmt = dbCon.prepareStatement(checkBalance);

		pstmt1 = dbCon.prepareStatement(queryGetAccountNumber);
		pstmt1.setDouble(1, holderContactNumber);
		ResultSet rs = pstmt1.executeQuery();
		while(rs.next()) {
		accountNumber = rs.getInt("Account_Number");
		}
		pstmt.setInt(1, accountNumber);
		rs = pstmt.executeQuery();
		while(rs.next()) {
		if(rs.getInt("Balance")<transactionAmount)
		throw new  ArithmeticException("not enough balance");
		}
		System.out.println("for withdarwing");
		System.out.println("Enter the account number of withrawer");
		int accountNumberWithdawer = scan.nextInt();
		scan.nextLine();
		String queryWithdraw = "UPDATE customer_details SET Balance = Balance - ? WHERE Account_Number = ? ";
		String transactionUpdate = "insert into transaction_details(Account_Number,Amount,Transaction_Time) values (?,?,?)";
		pstmt = dbCon.prepareStatement(queryWithdraw);
		pstmt.setInt(1, transactionAmount);
		pstmt.setInt(2,accountNumberWithdawer);

		if(pstmt.executeUpdate()>0) {
		System.out.println("balance updated");
		pstmt = dbCon.prepareStatement(transactionUpdate);
		pstmt.setInt(1, accountNumberWithdawer);
		pstmt.setInt(2, -transactionAmount);
		pstmt.setDate(3, d1);
		if(pstmt.executeUpdate()>0)
		System.out.println("trasaction updated");
		}
		else
		System.out.println("balance not updated");

		System.out.println("for receiving");
		System.out.println("Enter the account number of receiver");
		int accountNumberReceiver = scan.nextInt();
		scan.nextLine();
		String queryReceiver = "UPDATE customer_details SET Balance = Balance + ? WHERE Account_Number =? ";
		transactionUpdate = "insert into transaction_details(Account_Number,Amount,Transaction_Time) values (?,?,?)";
		pstmt1 = dbCon.prepareStatement(queryReceiver);
		pstmt1.setInt(1, transactionAmount);
		pstmt1.setInt(2,accountNumberReceiver);

		if(pstmt1.executeUpdate()>0) {
		System.out.println("balance updated");
		pstmt1 = dbCon.prepareStatement(transactionUpdate);
		pstmt1.setInt(1, accountNumberReceiver);
		pstmt1.setInt(2, transactionAmount);
		pstmt1.setDate(3, d1);

		if(pstmt1.executeUpdate()>0)
		System.out.println("transaction updated");
		}
		else
		System.out.println("balance not updated");

		} catch (SQLException e ) {
		System.out.println("problem while checking balance " + e.getMessage());
		}catch (ArithmeticException e ) {
		System.out.println();
		}


		}
		

	@Override
	public void getCustomerdetails(Connection dbCon) {
		// TODO Auto-generated method stub
		String query = "select * from customer_details";
		try {
		pstmt = dbCon.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
		System.out.print("Customer_Name is : " + rs.getString("Name"));
		System.out.print(" , Account Number  is : " + rs.getInt("Account_Number"));
		System.out.print(" , Phone_Number is : " + rs.getString("Phone_Number"));
		System.out.println(" , Aadhar_Number is : " + rs.getString("Aadhar_Number"));
		System.out.println(" , Balance is : " + rs.getInt("Balance"));
		System.out.println("********************");
		System.out.println(" ");
		System.out.println(" ");
		
		}
		} catch (SQLException e) {
		System.out.println("problem while printing " + e.getMessage() );
		}
		
		}
	

	@Override
	public void getTransactiondetails(Connection dbCon) {
		// TODO Auto-generated method stub
		String query = "select * from transaction_details";
		try {
		pstmt = dbCon.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
		System.out.print("Account_Number is : " + rs.getInt("Account_Number"));
		System.out.print(" , Transaction_id is : " + rs.getInt("Transaction_id"));
		System.out.print(" , Transaction_Time is : " + rs.getDate("Transaction_Time"));
		System.out.println(" , Amount is : " + rs.getInt("Amount"));
		System.out.println("********************");
		System.out.println(" ");
		System.out.println(" ");
		
		}
		} catch (SQLException e) {
		System.out.println("problem while printing " + e.getMessage() );
		}
		
		}
	
	@Override
	public void getBalance(Connection dbCon) {
	Scanner scan = new Scanner(System.in);
	String queryGetBalance = " select Balance from customer_Details where Phone_Number = ?";
	try {
	System.out.println("Enter the Phone Number");
	double ContactNumber = scan.nextDouble();
	scan.nextLine();

	pstmt = dbCon.prepareStatement(queryGetBalance);
	pstmt.setDouble(1, ContactNumber);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()) {
	System.out.println("the balance of account  is : " + rs.getInt("Balance"));
	}
	} catch (SQLException e) {
	System.out.println("Problem while printing balance " + e.getMessage() );
	}

	}
	

		
	}
	


