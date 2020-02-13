package com.ibm.service;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ServiceSql {
	Scanner scan = new Scanner(System.in);
    PreparedStatement pstmt;
	
	public Connection ServiceConnection(Connection dbCon) {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/starter?serverTimezone=UTC", "root", "");
		} catch (SQLException e) {
			System.out.println("problem while connection "  + e.getMessage());
		}
		return dbCon;
	}
	
	//insert Employee row in a Table
	public void insertData(Connection dbCon,String name,int number, String designation, int salary) {
		String query = "insert into employee_details value(?,?,?,?)";
		try {
		pstmt = dbCon.prepareStatement(query);
		pstmt.setString(1,name);
		pstmt.setInt(2,number);
		pstmt.setString(3,designation);
		pstmt.setInt(4,salary);
		
		if(pstmt.executeUpdate()>0)
			System.out.println("row inserted");
		else
			System.out.println("row not inserted");
		} catch (SQLException e) {
			System.out.println("problem while inserting " + e.getMessage());
		}
	}
		
//		Update table: userDetails
	public void updateData(Connection dbCon,int n) {
		
		
		
	switch(n) {
	case 1:
	try {
	pstmt = dbCon.prepareStatement("update employee_details set Salary=? where id=?");
	System.out.println("Enter the new Salary");
	int salary = scan.nextInt();
	scan.nextLine();
	System.out.println("Enter the employee number to be changed");
	int number = scan.nextInt();
	scan.nextLine();
	pstmt.setInt(2, number);
	pstmt.setInt(1, salary);
	if(pstmt.executeUpdate()>0)
	System.out.println("row updated");
	else
	System.out.println("not row updated");
	} catch (SQLException e) {
	System.out.println("problem while updating salary" + e.getMessage());
	}
	break;
	case 2:
	try {
	pstmt = dbCon.prepareStatement("update employee_details set Name=? where id=?");
	System.out.println("Enter the new Name");
	String name = scan.nextLine();
	System.out.println("Enter the employee number to be changed");
	int number = scan.nextInt();
	scan.nextLine();
	pstmt.setInt(2, number);
	pstmt.setString(1, name);
	if(pstmt.executeUpdate()>0)
	System.out.println("row updated");
	else
	System.out.println("not row updated");
	} catch (SQLException e) {
	System.out.println("problem while updating name" + e.getMessage());
	}
	break;
	case 3:
	try {
	pstmt = dbCon.prepareStatement("update employee_details set Designation=? where id=?");
	System.out.println("Enter the new Designation");
	String designation = scan.nextLine();
	System.out.println("Enter the employee number to be changed");
	int number = scan.nextInt();
	scan.nextLine();
	pstmt.setInt(2, number);
	pstmt.setString(1, designation);
	if(pstmt.executeUpdate()>0)
	System.out.println("row updated");
	else
	System.out.println("not row updated");
	} catch (SQLException e) {
	System.out.println("problem while updating designation" + e.getMessage());
	}
	break;
	case 4:
	try {
	pstmt = dbCon.prepareStatement("update employee_details set id=? where id=?");
	System.out.println("Enter the new Number");
	int newNumber = scan.nextInt();
	scan.nextLine();
	System.out.println("Enter the employee number to be changed");
	int number = scan.nextInt();
	scan.nextLine();
	pstmt.setInt(2, number);
	pstmt.setInt(1, newNumber);
	if(pstmt.executeUpdate()>0)
	System.out.println("row updated");
	else
	System.out.println("not row updated");
	} catch (SQLException e) {
	System.out.println("problem while updating number" + e.getMessage());
	}
	break;
	default:
	break;
	
	}
	}
	
	
// delete table:user details
public void deleteData(Connection dbCon,int n) {
	
	switch(n){
	case 1:
	try {
	pstmt = dbCon.prepareStatement("delete from employeedetails where id=?");
	System.out.println("Enter the employee id to be deleted");
	int number = scan.nextInt();
	scan.nextLine();
	pstmt.setInt(1, number);
	if(pstmt.executeUpdate()>0)
	System.out.println("row deleted");
	else
	System.out.println("not deleted");
	} catch (SQLException e) {
	System.out.println("problem while deleting number" + e.getMessage());
	}
	break;
	
	case 2:
	try {
	pstmt = dbCon.prepareStatement("delete from employeedetails where employeeName=?");
	System.out.println("Enter the employee name to be deleted");
	String name = scan.nextLine();
	pstmt.setString(1, name);
	if(pstmt.executeUpdate()>0)
	System.out.println("row deleted");
	else
	System.out.println("not deleted");
	} catch (SQLException e) {
	System.out.println("problem while deleting name" + e.getMessage());
	}
	break;
	
	case 3:
	try {
	pstmt = dbCon.prepareStatement("delete from employeedetails where employeeSalary=?");
	System.out.println("Enter the employee salary to be deleted");
	int salary = scan.nextInt();
	scan.nextLine();
	pstmt.setInt(1, salary);
	if(pstmt.executeUpdate()>0)
	System.out.println("row deleted");
	else
	System.out.println("not deleted");
	} catch (SQLException e) {
	System.out.println("problem while deleting salary" + e.getMessage());
	}
	break;
	
	case 4:
	try {
	pstmt = dbCon.prepareStatement("delete from employeedetails where employeeDesignation=?");
	System.out.println("Enter the employee designation to be deleted to be changed");
	String designation = scan.nextLine();
	pstmt.setString(1, designation);
	if(pstmt.executeUpdate()>0)
	System.out.println("row deleted");
	else
	System.out.println("not deleted");
	} catch (SQLException e) {
	System.out.println("problem while deleting designation" + e.getMessage());
	}
	break;
	default:
	break;
	}
	}

//display data
public void getData(Connection dbCon) {
	String query = "select * from employee_details";
	try {
	pstmt = dbCon.prepareStatement(query);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()) {
	System.out.print("EmployeName is : " + rs.getString("Name"));
	System.out.print(", EmployeNumber is : " + rs.getInt("id"));
	System.out.print(", EmployeDesination is : " + rs.getString("Designation"));
	System.out.println(", EmployeSalary is : " + rs.getInt("Salary"));
	System.out.println("********************");
	
	}
	} catch (SQLException e) {
	System.out.println("problem while printing " + e.getMessage() );
	}
	
	}

}
