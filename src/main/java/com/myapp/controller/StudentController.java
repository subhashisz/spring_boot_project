package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.model.Student;
import com.myapp.repository.StudentRepository;
/**
 * 
 * @author SUBHASHIS
 *
 */
@RestController
@RequestMapping(path = "/student") // This means URL's start with /student (after Application path)
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String emailId, @RequestParam String guardianName, @RequestParam String guardianEmail,
			@RequestParam String guardianMobile) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		/*
		 * Student student =
		 * Student.builder().firstName(firstName).lastName(lastName).emailId(emailId)
		 * .guardianName(guardianName).guardianEmail(guardianEmail).guardianMobile(
		 * guardianMobile).build();
		 */
		//studentRepository.save(student);
		return "Saved";
	}

	@GetMapping(path = "/findAll")
	public @ResponseBody Iterable<Student> getAllUsers() {
		// This returns a JSON or XML with the users
		return studentRepository.findAll();
	}
}
