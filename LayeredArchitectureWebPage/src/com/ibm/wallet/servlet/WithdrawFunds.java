package com.ibm.wallet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wallet.bean.Bean;
import com.ibm.wallet.service.Service;

@WebServlet("/withdrawFunds")
public class WithdrawFunds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Service service = new Service();
		Bean b = new Bean();
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		if(request.getSession(false)==null) {
			out.println("session ended");
			dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);		
		}
		else {
			b.setHolderContactNumber(Double.parseDouble(request.getParameter("holderContactNumber")));
			
			b.setTransctionAmount(Integer.parseInt(request.getParameter("transactionAmount")));
			java.util.Date d = new java.util.Date();
			java.sql.Date d1 = new java.sql.Date(d.getTime());
			b.setTransactionTime(d1);
			
			if(service.serveWithdrawFromAccount(b)==2) {
				out.println("Amount Withdrawn from an Account");
				dispatcher = request.getRequestDispatcher("logout.html");
				dispatcher.include(request, response);
			}
			else {
				out.println("Amount not withdrawn <br> Try again....");
				dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.include(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
