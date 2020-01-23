package com.capgemini.empspringmvc.dao;

import java.util.List;

import com.capgemini.empspringmvc.bean.EmployeeBean;

public interface EmployeeDAO {
	public EmployeeBean auth(String email, String password);

	public boolean register(EmployeeBean bean);

	public List<EmployeeBean> getAllEmployees(String key);

	public boolean changePassword(int id, String password);
}