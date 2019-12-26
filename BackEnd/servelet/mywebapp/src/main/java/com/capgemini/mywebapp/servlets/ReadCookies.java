package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readcookie")
public class ReadCookies extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get the cookies

		Cookie[] cookies = req.getCookies();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		req.getRequestDispatcher("./cookiepage.html").include(req, resp);

		out.println("<html>");
		out.println("<body>");
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				out.println("Cookies name=" + cookie.getName() + " Cookies value=" + cookie.getValue());
			}
		} else {
			out.println("Not formed");
		}
		out.println("</body>");
		out.println("</html>");

	}
}
