package com.myapp.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myapp.model.Employee;
import com.myapp.service.EmployeeService;

@Component
public class EmployeeHelper {

	Logger logger = LoggerFactory.getLogger(EmployeeHelper.class);

	@Autowired
	EmployeeService employeeService;

	public List<Employee> fetchEmployeeList() {
		logger.info("fetchEmployeeList()----------->{}",logger.getName());
		return employeeService.fetchEmployeeList();
	}
	
	public Employee saveEmployee(Employee employee) {
		logger.info("saveEmployee()----------->{}",logger.getName());
		return employeeService.saveEmployee(employee);
	}

}
