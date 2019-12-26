package com.capgemini.mywebapp.service;

import java.util.List;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;

public interface EmployeeService {
	public EmployeeInfoBean search(int emp_id);
	public EmployeeInfoBean authenticate(int empId,String Password);
	public boolean add(EmployeeInfoBean bean);
	public boolean delete(int emp_id);
	public boolean modify(EmployeeInfoBean bean);
	public List<EmployeeInfoBean> getAllEmployee();
	
}
