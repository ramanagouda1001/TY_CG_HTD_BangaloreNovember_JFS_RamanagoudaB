package com.capgemini.mywebapp.service;

import java.util.List;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.dao.EmployeeDAO;
import com.capgemini.mywebapp.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO dao=new EmployeeDAOImpl(); 
	@Override
	public EmployeeInfoBean search(int emp_id) {
		// TODO Auto-generated method stub
		return dao.search(emp_id);
	}
	@Override
	public EmployeeInfoBean authenticate(int empId, String Password) {
		// TODO Auto-generated method stub
		return dao.authenticate(empId, Password);
	}
	@Override
	public boolean add(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return dao.add(bean);
	}
	@Override
	public boolean delete(int emp_id) {
		// TODO Auto-generated method stub
		return dao.delete(emp_id);
	}
	@Override
	public boolean modify(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return dao.modify(bean);
	}
	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
		// TODO Auto-generated method stub
		return dao.getAllEmployee();
	}

}
