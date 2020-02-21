package com.ibm.wallet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.lang.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wallet.bean.Bean;
import com.ibm.wallet.service.Service;


@WebServlet("/customerdetails")
public class CustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbCon;
	PreparedStatement pstmt;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Service service = new Service();
		RequestDispatcher dispatcher = null;
		Bean b = new Bean();
		Random rand = new Random();
		
		if(request.getSession(false)==null) {
			out.println("session ended");
			dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);		
		}
		else {
			b.setHolderContactNumber(Double.parseDouble(request.getParameter("Phone_Number")));
			System.out.println(b.getHolderContactNumber());
			b.setHolderName(request.getParameter("Name"));
			b.setAadharNumber(request.getParameter("aadharNum"));
			b.setAccountBalance(Integer.parseInt(request.getParameter("Num")));
			int Account_Number = rand.nextInt(Integer.MAX_VALUE)+1;
			
			b.setAccountNumber(Account_Number);
			if(service.serveInsert(b)==2) {
				out.println("account created");
				dispatcher = request.getRequestDispatcher("logout.html");
				dispatcher.include(request, response);
			}
			else {
				out.println("account not created <br> try again");
				dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.include(request, response);
			}
		}	
			
			
	}

}
