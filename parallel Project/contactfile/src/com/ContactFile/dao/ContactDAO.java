package com.ContactFile.dao;

import java.util.List;

import com.ConatctFile.bean.Contact;

public interface ContactDAO {
	public List<Contact> contractDetails();
	
	public boolean addContact(Contact bean);
	
	public boolean deleteContact(String name);
	
	public Contact searchContact(String name);
	
	public boolean editNumber(String name,int number);
}
