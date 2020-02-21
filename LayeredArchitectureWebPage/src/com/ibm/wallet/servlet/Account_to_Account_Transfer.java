package com.ibm.wallet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wallet.bean.Bean;
import com.ibm.wallet.service.Service;

@WebServlet("/Account_to_Account_Transfer")
public class Account_to_Account_Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Service service = new Service();
		RequestDispatcher dispatcher = null;
		Random rand = new Random();
		Bean b = new Bean();
		if(request.getSession(false)==null) {
			out.println("session ended");
			dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);		
		}
		else {
			java.util.Date d = new java.util.Date();
			java.sql.Date d1 = new java.sql.Date(d.getTime());
			b.setTransactionTime(d1);
			
			b.setHolderContactNumber(Double.parseDouble(request.getParameter("senderContactNumber")));
			b.setTransctionAmount(Integer.parseInt(request.getParameter("transactionAmount")));
			if(service.serveWithdrawFromAccount(b)==2) {
				b.setHolderContactNumber(Double.parseDouble(request.getParameter("receiverContactNumber")));
				if(service.serveDepositInAccount(b)==2) {
					out.println("Amount Deposited");
				}
				else {
					out.println("Amount not deposited");
				}
			out.println("Amount Withrawn");
			dispatcher = request.getRequestDispatcher("logout.html");
			dispatcher.include(request, response);
			}
			else {
				out.println("Amount not withdraw <br> try again");
				dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.include(request, response);
			}
		}
	}

}

