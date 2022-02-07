package com.myapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.model.Employee;
import com.myapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> fetchEmployeeList() {
		logger.info("fetchEmployeeList()------->{}", logger.getName());
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		logger.info("saveEmployee()------->{}", logger.getName());
		return employeeRepository.save(employee);
	}

}
