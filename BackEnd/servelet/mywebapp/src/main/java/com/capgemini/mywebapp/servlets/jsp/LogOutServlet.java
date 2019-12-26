package com.capgemini.mywebapp.servlets.jsp;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

@WebServlet("/logout2")
public class LogOutServlet  extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession(false);
	if(session!=null)
	{
		session.invalidate();
		req.setAttribute("msg","Bye");
	}
	else
	{
		req.setAttribute("msg","hi");
	
	}
	req.getRequestDispatcher("./loginform").forward(req, resp);
}
}
