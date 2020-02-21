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


@WebServlet("/PrintBalance")
public class PrintBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Service service= new Service();
		RequestDispatcher dispatcher = null;
		PrintWriter out = response.getWriter();
		Bean b = new Bean();
		if(request.getSession(false)==null) {
			out.println("session ended");
			dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);		
		}
		else {
			b.setHolderContactNumber(Double.parseDouble(request.getParameter("holderContactNumber")));
			
			Bean rs = service.serveGetBalance(b);
			out.println("the account balance is : " + rs.getAccountBalance());
			out.println(" <br><br>");
			dispatcher = request.getRequestDispatcher("logout.html");
			dispatcher.include(request, response);
		}
		
		
	}

	
}
