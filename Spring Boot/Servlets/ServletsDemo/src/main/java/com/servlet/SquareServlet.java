package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SquareServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int k = (int) req.getAttribute("k");
		k=k*k;
		
		
		PrintWriter output=res.getWriter();
		output.println("result: "+k);
		
		System.out.println("Heello");
	}

}
