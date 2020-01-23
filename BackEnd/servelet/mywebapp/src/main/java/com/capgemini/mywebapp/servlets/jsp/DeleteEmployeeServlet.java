package com.capgemini.mywebapp.servlets.jsp;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/deleteEmployee6")

public class DeleteEmployeeServlet  extends HttpServlet{
	

		private EmployeeService service=new EmployeeServiceImpl();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session=req.getSession(false);
			if(session!=null) {
				int empId=Integer.parseInt(req.getParameter("empId"));
				if(service.delete(empId)) {
					req.setAttribute("msg", "Deleted successfully");
					req.getRequestDispatcher("./delete").forward(req, resp);
				}else {
					req.setAttribute("msg","Id does not exists");
					req.getRequestDispatcher("./delete").forward(req, resp);
				}
			}else {
				req.setAttribute("msg", "please login first");
				req.getRequestDispatcher("./loginFormJsp.jsp").forward(req, resp);
			}
		}
	}