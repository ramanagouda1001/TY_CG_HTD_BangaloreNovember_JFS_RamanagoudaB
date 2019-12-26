package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/searchEmployee")
public class SearchEmployeeServlet extends HttpServlet{
	
	 private EmployeeService dao=new EmployeeServiceImpl();
	 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//get the form data
		
		String empIdVal=req.getParameter("empid");
		EmployeeInfoBean bean=dao.search(Integer.parseInt(empIdVal));
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(bean!=null)
		{
			out.println("Employee id"+bean.getEmp_id());
			out.println("<br>employee name"+bean.getName());
			out.println("<br>employee age"+bean.getAge());
			out.println("<br>employee salary"+bean.getSalary());
			out.println("<br>employee designation"+bean.getDesignation());
		}
		else
		{
			out.println("not found");
		}
		out.println("</body>");
		out.println("</html>");
	}//end of do get
}// end of class
