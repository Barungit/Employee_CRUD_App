package com.manage.emplyees.employeeCrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manage.emplyees.employeeCrud.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	//define entity manager field
	private EntityManager entityManager;
	
	//constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager em) {
		entityManager = em;
	}
	
	
	@Override
	public List<Employee> findAll() {
		// creating the query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		//execute and get results
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
		
	}

}
