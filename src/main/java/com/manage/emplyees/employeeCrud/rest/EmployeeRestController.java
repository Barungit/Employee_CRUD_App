package com.manage.emplyees.employeeCrud.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.manage.emplyees.employeeCrud.entity.Employee;
import com.manage.emplyees.employeeCrud.service.EmployeeService;
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// GET ALL EMPLOYEES
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return  employeeService.findAll();
	}
	
	//GET A EMPLOYEE
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		return theEmployee;
	}
	
	
	//save a employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	//update a employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	//delete a employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);
		if(tempEmployee==null) {
			throw new RuntimeException("Employee Id :"+ employeeId + " not found!");
		}
		employeeService.deleteById(employeeId);
		return "Deleted Employe with ID :" + employeeId;
	}
		
}
