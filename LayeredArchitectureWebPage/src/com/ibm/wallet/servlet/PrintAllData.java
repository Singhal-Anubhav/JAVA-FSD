package com.ibm.wallet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wallet.bean.Bean;
import com.ibm.wallet.service.Service;


@WebServlet("/PrintAllData")
public class PrintAllData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Service service = new Service();
		RequestDispatcher dispatcher = null;
		Bean b = new Bean();
		b.setHolderContactNumber(Double.parseDouble(request.getParameter("number")));
		
		if(request.getSession(false)==null) {
			out.println("session ended");
			dispatcher = request.getRequestDispatcher("index.html");
			
			dispatcher.include(request, response);		
		}
		else {
			List<Bean> bilers = service.serveGetAllData(b);
			for(Bean val : bilers) {
				out.println(val.printData() + "<br>");
				out.println("*********  <br>");
	
			}
			dispatcher = request.getRequestDispatcher("logout.html");
			dispatcher.include(request, response);
		}
	}

	

}
