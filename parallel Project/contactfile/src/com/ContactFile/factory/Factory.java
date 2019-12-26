package com.ContactFile.factory;

import com.ContactFile.dao.ContactDAO;
import com.ContactFile.dao.ContactDAOImpl;
import com.ContactFile.services.ContactService;
import com.ContactFile.services.ContactServicesImpl;

public class Factory {
	private Factory()
	{
		
	}
	public static ContactDAO intanceOfContractDAOImpl()
	{
		ContactDAO dao=new ContactDAOImpl();
		return dao;
	}
	public static ContactService intanceOfContactServieImpl()
	{
		ContactService dao=new ContactServicesImpl();
		return dao; 
	}
}
