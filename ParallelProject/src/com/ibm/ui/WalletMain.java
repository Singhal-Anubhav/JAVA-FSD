package com.ibm.ui;

import java.util.Scanner;
import com.ibm.service.*;

public class WalletMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		Service service = new Service();
		service.runDao();
		while(true) {
			
		System.out.println("Press 1 for inserting a new customer");
		System.out.println("Press 2 for updating an existing customer");
		System.out.println("Press 3 for deposity any amount");
		System.out.println("Press 4 for withdarwing any amount");
		System.out.println("Press 5 for tranfering funds btw Accounts..");
		System.out.println("Press 6 for printing Customer details");
		System.out.println("Press 7 for printig all transactions");
		int n = scan.nextInt();
		scan.nextLine();
		service.extractFunctinsOfDao(n);
		
		System.out.println("Do yo want to Do any Other Operation(Y/N)....");
		String deci = scan.nextLine();
		if(deci.equals("N")) {
			break;
		}

		}

		

	}

}
