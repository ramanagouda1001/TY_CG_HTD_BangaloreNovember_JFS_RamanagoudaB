package com.capgemini.mywebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");

	@Override
	public EmployeeInfoBean search(int emp_id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EmployeeInfoBean bean = entityManager.find(EmployeeInfoBean.class, emp_id);
		entityManager.close();

		return bean;
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String Password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from EmployeeInfoBean where emp_id=:empid and password=:password ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("empid", empId);
		query.setParameter("password", Password);

		EmployeeInfoBean bean = null;
		try {
			bean = (EmployeeInfoBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return bean;
	}

	@Override
	public boolean add(EmployeeInfoBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.persist(bean);
			transaction.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();

		return false;
	}

	@Override
	public boolean delete(int emp_id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			EmployeeInfoBean bean = entityManager.find(EmployeeInfoBean.class, emp_id);
			entityManager.remove(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();

		return false;
	}

	@Override
	public boolean modify(EmployeeInfoBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		EmployeeInfoBean exist=entityManager.find(EmployeeInfoBean.class, bean.getEmp_id());
		EntityTransaction transaction=entityManager.getTransaction();
		if(exist!=null)
		{
			try {
				transaction.begin();
				String newName=bean.getName();
				if(newName!=null && !newName.isEmpty())
				{
					exist.setName(newName);
				}
				int newage=bean.getAge();
				if(newage>0)
				{
					exist.setAge(newage);
				}
				double newsalary=bean.getSalary();
				if(newsalary>0)
				{
					exist.setSalary(newsalary);
				}
				String newDesc=bean.getDesignation();
				if(newDesc!=null && !newDesc.isEmpty())
				{
					exist.setDesignation(newDesc);
				}
				String newpassword=bean.getPassword();
				if(newpassword!=null && !newpassword.isEmpty())
				{
					exist.setPassword(newpassword);
				}
				transaction.commit();
				return true;
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		return false;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from EmployeeInfoBean";
		Query query = entityManager.createQuery(jpql);
		List<EmployeeInfoBean> list=query.getResultList();
		entityManager.close();
		return list;
	}

}
