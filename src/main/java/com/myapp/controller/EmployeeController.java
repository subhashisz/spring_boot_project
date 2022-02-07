package com.myapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.helper.EmployeeHelper;
import com.myapp.model.Employee;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeHelper employeeHelper;

	@GetMapping
	public List<Employee> fetchEmployeeList() {
		logger.info("fetchEmployeeList() ---------> {}", logger.getName());
		return employeeHelper.fetchEmployeeList();
	}

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		logger.info("saveEmployee()----------->{}", logger.getName());
		logger.info(employee.toString());
		return employeeHelper.saveEmployee(employee);
	}

}
