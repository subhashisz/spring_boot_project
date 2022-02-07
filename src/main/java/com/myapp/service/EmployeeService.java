package com.myapp.service;

import java.util.List;

import com.myapp.model.Employee;

public interface EmployeeService {

	List<Employee> fetchEmployeeList();

	Employee saveEmployee(Employee employee);

}
