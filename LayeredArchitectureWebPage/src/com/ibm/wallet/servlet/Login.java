package com.ibm.wallet.servlet;

import java.lang.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.wallet.bean.Bean;
import com.ibm.wallet.service.Service;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbCon;
	PreparedStatement pstmt;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Set the Content Type
		response.setContentType("text/html");
		
		Bean b = new Bean();
		PrintWriter out = response.getWriter();
		
	    Service service = new Service();
		HttpSession session = request.getSession();
		System.out.println(request.getParameter("Phone_Number"));
		
		b.setHolderContactNumber(Double.parseDouble(request.getParameter("Phone_Number")));
		b.setPassword(request.getParameter("password"));
		
		if(service.serveCheckPassword(b)==2) {
			out.println("logged in");
			RequestDispatcher dispatcher = request.getRequestDispatcher("options.html");
			dispatcher.include(request, response);
		}
		else if(service.serveCheckPassword(b)==1) {
			out.println("Wrong Password Please Re-Enter...");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.include(request, response);
		}
		else {
			out.println("Wrong Credentials..Register Yourself first");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
		}
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//if(request.getSession(false)==null) {
//			
//			response.getWriter().println("Session Not Found");
//			response.getWriter().println("Pease Fill your Credentials first...");
//			RequestDispatcher dispatch = request.getRequestDispatcher(".html");
//					dispatch.include(request, response);
//					
//		}
//		else {
//		try
//		{
//			Class.forName("com.mysql.jdbc.Driver");
//		 dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet?serverTimezone=IST", "root", "");
//	//response.getWriter().println("Connected");
//		System.out.println("Connected");
//		}
//		catch(SQLException e)
//		{
//			//response.getWriter().println("Not Connected");
//			System.out.println("Not connected" + e.getMessage());
//		}
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//     catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Driver issues: " + e.getMessage());
//		}
//		
//		
//		
//		String ph=request.getParameter("phoneNum");	
//		String password=request.getParameter("password");
//		
//		
//		String checkQry="select * from login_details where Phone_Number=? and password=? ";
//	
//		try
//		{
//		pstmt=dbCon.prepareStatement(checkQry);
//		
//		pstmt.setString(1, ph);
//		pstmt.setString(2,password);
//		
//		ResultSet rs=pstmt.executeQuery();
//		
////		if(uname.equals(rs.getString("UserName")) && password.equals(rs.getString("Password")))
////		
////			{
//			
//			
//	while(rs.next())
//		
//	{
//		if(ph.trim().equals(rs.getString("Phone_Number")) && password.trim().equals(rs.getString("password"))) {
//		request.getSession().setAttribute("ph",ph);
//		
//		PrintWriter out=response.getWriter();	
//	   out.println("Welcome:" );
//	   RequestDispatcher dispatcher = request.getRequestDispatcher(".html");
//	   //response.sendRedirect("logout.html");
//		dispatcher.include(request, response);
//		}
////		else if(userName.trim().equals(rs.getString("UserName")) && password.trim().equals(rs.getString("password"))){
////			PrintWriter out=response.getWriter();	
////			   out.println("Wrong Password Enter for :"+userName);
////			   out.println();
////			    response.encodeRedirectURL("index.html");
////				//dispatcher.include(request, response);
////		}
//		else 
//		{
//			PrintWriter out=response.getWriter();
//			out.println("Create Account first");
//			out.println();
//			//response.sendRedirect("index.html");
//			RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
//		    dispatcher.include(request, response);
//		}
//	}
//	
//	
//	
//			
//		
//		} 
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		}
//		
//	}

