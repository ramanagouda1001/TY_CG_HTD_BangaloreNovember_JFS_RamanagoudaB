package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url="./currentDate";
		 resp.setContentType("text/html");
		 PrintWriter printWriter=resp.getWriter();
		 printWriter.println("<html>");
		 printWriter.println("<body>");
		 printWriter.println("<h2> hello world</h2>");
		 printWriter.println("</body>");
		 printWriter.println("</html>");
		
		RequestDispatcher dispatcher=req.getRequestDispatcher(url);
		
		dispatcher.forward(req, resp);
		
		// in case of forward external resource does not wrok because it serach wiyhin the server
		// incase of forward url doesnot change to forwaded url
		//inacase of redirect url changes
		
		//the response do not include the current servelt response only response of forwaded servelt
		
	}//end of do get
}//end of class
