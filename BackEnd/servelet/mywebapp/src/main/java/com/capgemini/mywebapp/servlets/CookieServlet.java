package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createcookie")
public class CookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie myCookie=new Cookie("Emp", "Ramanagouda");
		myCookie.setMaxAge(20);// automatically deleted in 20 sec
		resp.addCookie(myCookie);
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("./cookiepage.html");
		dispatcher.include(req, resp);

		out.println("<html>");
		out.println("<body>");
		out.println("<h2> Created cookies </h2>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
