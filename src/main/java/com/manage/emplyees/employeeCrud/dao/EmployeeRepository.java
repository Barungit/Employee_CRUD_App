package com.manage.emplyees.employeeCrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manage.emplyees.employeeCrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
