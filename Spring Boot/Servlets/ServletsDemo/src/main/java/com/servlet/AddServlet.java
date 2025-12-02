package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i+j;

		 
		req.setAttribute("k",k);
//	
		System.out.println(k); 
//		PrintWriter output = res.getWriter();
//		output.println("result :" +k);
//		
//		
//		
//		//RequestDispatcher
		RequestDispatcher rd = req.getRequestDispatcher("sq");
		rd.include(req, res);
//		
		
//		res.sendRedirect("sq?k="+k);
		
		
		
	}
}
