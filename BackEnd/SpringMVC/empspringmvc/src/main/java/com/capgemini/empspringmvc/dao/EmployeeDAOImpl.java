package com.capgemini.empspringmvc.dao;

import java.util.List;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.empspringmvc.bean.EmployeeBean;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@PersistenceUnit
	private EntityManagerFactory factroy;
	
	@Override
	public EmployeeBean auth(String email, String password) {
		EntityManager manager=factroy.createEntityManager();
		String jpql="from EmployeeBean where email=:email";
		TypedQuery<EmployeeBean> query=manager.createQuery(jpql,EmployeeBean.class);
		query.setParameter("email", email);
		//query.setParameter("password", password);
		try
		{
			EmployeeBean bean=query.getSingleResult();
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			if(encoder.matches(password, bean.getPassword()))
			{
				return bean;
				
			}
			else
			{
				return null;
			}
		}
		catch (Exception e) {
			return null;
		}		
	}

	@Override
	public boolean register(EmployeeBean bean) {
		EntityManager entityManager=factroy.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try
		{
			transaction.begin();
			entityManager.persist(bean);
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
	}
	@Override
	public List<EmployeeBean> getAllEmployees(String key) {
		EntityManager manager=factroy.createEntityManager();
		String jpql="from EmployeeBean where name=:name or email=:email";
		TypedQuery<EmployeeBean> query=manager.createQuery(jpql,EmployeeBean.class);
		query.setParameter("name", key);
		query.setParameter("email", key);
		return query.getResultList();
	}

	@Override
	public boolean changePassword(int id, String password) {
		EntityManager entityManager=factroy.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		String jpql="update EmployeeBean set password=:password where id=:id";
		try {
			transaction.begin();
			Query query=entityManager.createQuery(jpql);
			query.setParameter("password", password);
			query.setParameter("id", id);
			int count=query.executeUpdate();
			transaction.commit();
			if(count>0)
				return true;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}