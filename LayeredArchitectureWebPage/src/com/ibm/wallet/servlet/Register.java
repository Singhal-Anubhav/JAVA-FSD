package com.ibm.wallet.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbCon;
	PreparedStatement pstmt;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String Ph=request.getParameter("phoneNum");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		
		
		String inputQuery ="insert into login_details values(?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet?serverTimezone=IST", "root", "");
			 pstmt= dbCon.prepareStatement(inputQuery);
			 pstmt.setString(1,Ph);
			 
			 if(password.equals(password2)) {
			 pstmt.setString(2, password);
				if(pstmt.executeUpdate()>0) {
					System.out.println("Inserted successfully");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("customerDetails.html");
					dispatcher.include(request, response);}
				else
					System.out.println("problem with insertion");
				
			 }
			 else {
				 response.getWriter().println("Password not Matched....re-enter");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("register.html");
					dispatcher.include(request, response);
				
			}}catch(SQLException e)
			{
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}
