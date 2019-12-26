package com.capgemini.mywebapp.servlets.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/login2")
public class Loginservlet extends HttpServlet {
		private EmployeeService service=new EmployeeServiceImpl();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String empIdval=req.getParameter("empId");
			String password=req.getParameter("password");
			
			
			int empId=Integer.parseInt(empIdval);

			EmployeeInfoBean bean=service.authenticate(empId, password);
			if(bean!=null)
			{
				HttpSession session=req.getSession(true);
				//session.setMaxInactiveInterval(10);
				session.setAttribute("bean",bean);
				req.getRequestDispatcher("./HomeJSP.jsp").forward(req, resp);
				//valid
			}
			else
			{
				req.setAttribute("msg", "Invalid credentials");
				req.getRequestDispatcher("./loginform").forward(req, resp);
				//invalid
			}
		}
}//end of class
