package com.capgemini.mywebapp.servlets.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/uppdateEmployee22")
public class UpdateEmployee  extends  HttpServlet{

	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			int empId=Integer.parseInt(req.getParameter("empId"));
			String name=req.getParameter("name");
			String age=req.getParameter("age");
			String salary=req.getParameter("salary");
			String password=req.getParameter("password");
			String designation=req.getParameter("designation");
			
			
			EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
			
			if(age!=null && !age.isEmpty())
			{
				int agen=Integer.parseInt(age);
				employeeInfoBean.setAge(agen);
				
			}
			employeeInfoBean.setEmp_id(empId);
			employeeInfoBean.setDesignation(designation);
			employeeInfoBean.setName(name);
			if(salary!=null && !salary.isEmpty())
			{
				double salaryn=Double.parseDouble(salary);
				employeeInfoBean.setSalary(salaryn);
				
			}
			employeeInfoBean.setPassword(password);
			
			if(service.modify(employeeInfoBean))
			{
				req.setAttribute("msg", "updated");
			}
			else
			{
				req.setAttribute("msg", "Failed");
			}
			req.getRequestDispatcher("./update").forward(req, resp);
		}
		else
		{
			//valid
			req.setAttribute("msg", "login first");
			req.getRequestDispatcher("./logInForm.jsp").forward(req, resp);
		}
	}
}//end class
