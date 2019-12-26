package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class GetEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idVal = req.getParameter("id");

		// get the context-param

		ServletContext context = getServletContext();
		String contextParamValue = context.getInitParameter("myContextParam");

		// get config param
		ServletConfig config = getServletConfig();
		String configParamVal = config.getInitParameter("myConfigParm");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Employee ID = " + idVal);
		out.println("</br>Employee Name is=Ramanagouda");
		out.println("</br>Salary is 25000");

		//
		out.println("</br></br>Context Value" + contextParamValue);
		out.println("</br></br>Context Value" + configParamVal);
		
		out.println("</body>");
		out.println("</html>");
	}// end of doGet
}// End of class
