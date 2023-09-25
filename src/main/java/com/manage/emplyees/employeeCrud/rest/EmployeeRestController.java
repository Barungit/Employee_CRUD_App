package com.manage.emplyees.employeeCrud.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.emplyees.employeeCrud.dao.EmployeeDAO;
import com.manage.emplyees.employeeCrud.entity.Employee;
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return  employeeDAO.findAll();
	}
}