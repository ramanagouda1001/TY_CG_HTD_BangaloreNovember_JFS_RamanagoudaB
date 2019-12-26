package com.capgemini.mywebapp.dao;

import java.util.List;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;

public interface EmployeeDAO {

		public EmployeeInfoBean authenticate(int empId,String Password);
		public EmployeeInfoBean search(int emp_id);
		public boolean add(EmployeeInfoBean bean);
		public boolean delete(int emp_id);
		public boolean modify(EmployeeInfoBean bean);
		public List<EmployeeInfoBean> getAllEmployee();

}
