package com.ibm.service;


import java.sql.Connection;
import java.util.Scanner;

import com.ibm.dao.*;

public class Service implements ServiceInterface  {
Dao dao = new Dao();
Connection dbCon;
Scanner scan = new Scanner(System.in);

@Override
public Connection runDao() {
dbCon = dao.ServiceConnection(dbCon);
return dbCon;
}

public void extractFunctinsOfDao(int n) {
switch(n) {

case 1:  //inserting the new customer
	scan.nextLine();
	System.out.println("Enter the Name of an Customer");
	String Name = scan.nextLine();
	System.out.println("Enter the phone Number of an customer...");
	double Phone_Number = scan.nextDouble();
	scan.nextLine();
	System.out.println("Enter the Aadhar Number of an customer...");
	String Aadhar_Number = scan.nextLine();
	System.out.println("Enter the Balance with which You need to open an Account...");
	int Balance = scan.nextInt();
	
      dao.insertCustomerDetails(dbCon, Name, Phone_Number, Aadhar_Number, Balance);
break;
case 2:  //updating the value
	scan.hasNextLine();
	System.out.println("Enter the 1 if u need to Update the Name...");
	System.out.println("Enter 2 if u need to Update the Phone Number...");
	System.out.println("Enter 3 if u need to update the Aadhar Number of a Customer...");
	int n1 = scan.nextInt();
	
      dao.updateCustomerDetails( dbCon, n1);
break;
case 3:  //money deposit in bank 
      dao.moneyDeposit( dbCon);
break;
case 4:  //money withdrawal fron bank
        dao.moneyWithdrawal(dbCon);
break;

case 5:  //funds transfer btw two accounts
dao.AccountToAccountTransfer(dbCon);
break;

case 6: //displaying Customer details
dao.getCustomerdetails(dbCon);
break;

case 7: // displaying transaction details
dao.getTransactiondetails(dbCon);
break;
}

}
}