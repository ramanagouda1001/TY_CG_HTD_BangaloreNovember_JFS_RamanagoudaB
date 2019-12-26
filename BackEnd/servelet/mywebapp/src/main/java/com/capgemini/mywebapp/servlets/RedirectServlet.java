package com.capgemini.mywebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	//	String url="http://www.facebook.com"; // external resource
		String url="./currentDate";// relative path //internal resource
		//or both are same
		String url1="http://localhost:8080/mywebapp/currentDate";//absoulte path  // internal resource
		//the purpose of using . is see it in current request
		resp.sendRedirect(url);
		
		
		//redirect happens only at browser side
	}
}
