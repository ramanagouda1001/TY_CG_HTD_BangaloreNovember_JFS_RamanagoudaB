package com.capgemini.forestmanagementrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementrest.bean.Account;
import com.capgemini.forestmanagementrest.dao.AdminDAO;
import com.capgemini.forestmanagementrest.exception.ForestManagementSystem;
import com.capgemini.forestmanagementrest.validation.Validation;

import lombok.val;

@Service
public class AdminServicesImpl implements AdminServices {

	@Autowired
	private AdminDAO dao;

	@Override
	public boolean getAdmin(Account admin) {
		// TODO Auto-generated method stub
		if (Validation.isValidEmail(admin.getUsername())) {
			if (Validation.validPassword(admin.getPassword())) {
				if (admin.getRole().equalsIgnoreCase("admin") || (admin.getRole().equalsIgnoreCase("client"))
						|| (admin.getRole().equalsIgnoreCase("product"))) {
					return dao.getAdmin(admin);
				} else {
					throw new ForestManagementSystem("Only Admin,Client,product allowed");
				}
			} else {
				throw new ForestManagementSystem("invalid password format");
			}
		} else {
			throw new ForestManagementSystem("Invalid mail format valid format is (abc@gmail.com)");
		}
	}

	@Override
	public boolean addAccount(Account admin) {
		if (Validation.isValidEmail(admin.getUsername())) {
			if (Validation.validPassword(admin.getPassword())) {
				if (admin.getRole().equalsIgnoreCase("admin") || (admin.getRole().equalsIgnoreCase("client"))
						|| (admin.getRole().equalsIgnoreCase("product"))) {
					return dao.addAccount(admin);
				} else {
					throw new ForestManagementSystem("Only Admin,Client,product allowed");
				}
			} else {
				throw new ForestManagementSystem("invalid password format");
			}
		} else {
			throw new ForestManagementSystem("Invalid mail format valid format is (abc@gmail.com)");
		}	
	}
	@Override
	public boolean deleteAccount(Account bean) {
		if(Validation.isValidEmail(bean.getUsername())) {
			if(Validation.validPassword(bean.getPassword())) {
				return dao.deleteAccount(bean);
			} else {
				throw new ForestManagementSystem("Invalid Password Format");
			}
		} else {
			throw new ForestManagementSystem("Invalid mail format valid format is (abc@gmail.com)");
		}
	}

	@Override
	public List<Account> listAccount() {
		// TODO Auto-generated method stub
		return dao.listAccount();
	}
}
