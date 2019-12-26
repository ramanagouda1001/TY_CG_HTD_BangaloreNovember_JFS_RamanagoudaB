package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/searchEmployee2")
public class SearchEmployeeServlet2 extends HttpServlet {
	private EmployeeService dao=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		// the purpose of sending false because it return the dame session that already
		// exist
		// see in LoginServelt 35
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (session != null) {
			//valid session
			String empIdVal=req.getParameter("empid");
			EmployeeInfoBean bean=dao.search(Integer.parseInt(empIdVal));
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
				out.println("<h2 style='color:red'>not found</h2>");
			}

		}
		else
		{
			//invalid session
			out.println("Plz login first");
			req.getRequestDispatcher("loginPage.html").include(req, resp);
			
		}
		out.println("</body>");
		out.println("</html>");
	}
}
