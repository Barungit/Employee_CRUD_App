package com.manage.emplyees.employeeCrud.dao;

import java.util.List;

import com.manage.emplyees.employeeCrud.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
}
