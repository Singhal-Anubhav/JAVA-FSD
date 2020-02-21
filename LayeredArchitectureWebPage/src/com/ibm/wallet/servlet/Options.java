package com.ibm.wallet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/options")
public class Options extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		if(request.getSession(false)==null) {
			out.println("session ended");
			dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);		
		}
		else {
			String choice = request.getParameter("choice");
			
			 if(choice.trim().equals("updating_name_of_exiting_cutomer")) {
				dispatcher = request.getRequestDispatcher("updateName.html");
				dispatcher.include(request, response);
			}
			else if(choice.trim().equals("updating_contact_number_of_existing_customer")) {
				dispatcher = request.getRequestDispatcher("updateNumber.html");
				dispatcher.include(request, response);
			}
			else if(choice.trim().equals("deposit_ammount")) {
				dispatcher = request.getRequestDispatcher("DepositFunds.html");
				dispatcher.include(request, response);
			}
			else if(choice.trim().equals("withdraw_ammount")){
				dispatcher = request.getRequestDispatcher("WithdrawFunds.html");
				dispatcher.include(request, response);	
			}
			else if(choice.trim().equals("Account_to_Account_Transfer")) {
				dispatcher = request.getRequestDispatcher("Account_to_Account_Transfer.html");
				dispatcher.include(request, response);
			}
			else if(choice.trim().equals("get_balance")) {
				dispatcher = request.getRequestDispatcher("PrintBalance.html");
				dispatcher.include(request, response);
			}
			else if(choice.trim().equals("get_transaction")) {
				dispatcher = request.getRequestDispatcher("PrintTransactions.html");
				dispatcher.include(request, response);
			}
			else if(choice.trim().equals("get_account_details")) {
				dispatcher = request.getRequestDispatcher("PrintAllData.html");
				dispatcher.include(request, response);
			}
			else {
				dispatcher = request.getRequestDispatcher("logout.html");
				dispatcher.include(request, response);
			}
		}
	}	

}
