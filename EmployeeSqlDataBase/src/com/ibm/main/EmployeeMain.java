package com.ibm.main;

import com.ibm.service.ServiceSql;

import java.util.Scanner;
import java.sql.Connection;

public class EmployeeMain {
	
	static Connection dbCon;
	static ServiceSql obj =new ServiceSql();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		dbCon = obj.ServiceConnection(dbCon);
		System.out.println("Hi!Please Enter the Num according the Following Operation");
		System.out.println(" ");
		while(true) {
			System.out.println("Enter 1 if you want to insert an Emmployee details... ");
			System.out.println("Enter 2 if you Want to update an Employee details...");
			System.out.println("Enter 3 if you Want to delete an Employee details...");
			System.out.println("Enter 4 if you Want to display an Existing Employee details... ");
			int n = scan.nextInt();
			scan.nextLine();
			
			switch(n){
			case 1 :
				System.out.println("enter the employee name");
				String name = scan.nextLine();
				System.out.println("enter the the employee number");
				int number = scan.nextInt();
				scan.nextLine();
				System.out.println("enter the employee designation");
				String designation = scan.nextLine();
				System.out.println("enter the employee salary");
				int salary = scan.nextInt();
				scan.nextLine();
				
				obj.insertData(dbCon,name,number,designation,salary);
				break;
			case 2 :
				System.out.println("Press 1 to update employee salary ");
				System.out.println("Press 2 to update employee name");
				System.out.println("Press 3 to update employee desigantion");
				System.out.println("Press 4 to update employee number ");
				int m = scan.nextInt();
				scan.nextLine();
				obj.updateData(dbCon,m);
				break;
				
			case 3 :
				System.out.println("Press 1 to delete from employee number");
				System.out.println("Press 2 to delete from employee name");
				System.out.println("Press 3 to delete from employee salary");
				System.out.println("Press 4 to delete from employee designation");
				int k= scan.nextInt();
				scan.nextLine();
				
				obj.deleteData(dbCon,k);
				break;
				
			case 4 :
				
				obj.getData(dbCon);
				break;
				
				}
			
			System.out.println("Do you Want to do any more Operation(Y/N)....");
			String m = scan.nextLine();
			if(m.equals("N")) {
				break;
			}
		}
		
		

	}

}

