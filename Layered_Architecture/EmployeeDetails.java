package com.ibm.eis.ui;

import com.ibm.eis.bean.Employee;
import com.ibm.eis.service.EmployeeService;

import java.util.Scanner;



public class EmployeeDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Hi! Enter the details of an Employee...");
		while(true) {
		System.out.println("Enter the name of an Employee...");
		String name =scan.nextLine();
		
		System.out.println("Enter the id of an Employee...");
		int id =scan.nextInt();
		
		System.out.println("Enter the Salary of an Employee...");
		int salary =scan.nextInt();
		
		scan.nextLine();
		
		System.out.println("Enter the Designation of an Employee...");
		String designation =scan.nextLine();
		
		Employee e = new Employee(id,salary,name,designation);
		EmployeeService o = new EmployeeService();
		System.out.println(o.insuranceScheme(e));
		
		System.out.println("Want to enter the more employee details (Y/N)...");
		String in = scan.nextLine();
		
		if(in.equals("N")) {
			break;
		}
		else {
			continue;
		}
		
		}

	}

}
