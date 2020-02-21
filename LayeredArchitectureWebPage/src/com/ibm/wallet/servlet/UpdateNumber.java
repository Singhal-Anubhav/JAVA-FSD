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


@WebServlet("/updateNumber")
public class UpdateNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher =  null;
		Bean b = new Bean();
		Service service = new Service();
		if(request.getSession(false)==null) {
			out.println("session ended");
			dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);		
		}
		else {
			b.setAccountNumber(Integer.parseInt(request.getParameter("accountNumber")));
			b.setHolderContactNumber(Double.parseDouble(request.getParameter("newNumber")));
			if(service.serveUpdateNumber(b)>0) {
				out.println("Number updated");
				dispatcher = request.getRequestDispatcher("logout.html");
				dispatcher.include(request, response);
			}
			else {
				out.println("Number not updated<br> Please Retry..");
				dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.include(request, response);
			}
		}
		
		
	}


}
