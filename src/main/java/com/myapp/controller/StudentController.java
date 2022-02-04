package com.myapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.helper.StudentHelper;
import com.myapp.model.Student;

/**
 * 
 * @author SUBHASHIS
 *
 */
@RestController
@RequestMapping(path = "/student") // This means URL's start with /student (after Application path)
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentHelper studentHelper;

	public Student saveStudent(@PathVariable Student student) {
		logger.info("LOG -> {} -------->saveStudent ", logger.getName());
		return studentHelper.saveStudent(student);
	}

	public Student saveStudentWithGuardian(@PathVariable Student student) {
		logger.info("LOG -> {} -------->saveStudent ", logger.getName());
		return studentHelper.saveStudentWithGuardian(student);

	}

	public List<Student> findAllStudent() {
		logger.info("LOG -> {} -------->saveStudent ", logger.getName());
		return studentHelper.findAllStudent();

	}

	public List<Student> findStudentByFirstName() {
		logger.info("LOG -> {} -------->saveStudent ", logger.getName());
		return studentHelper.findStudentByFirstName("shivam");
	}

	public List<Student> findStudentByFirstNameContaining(String contains) {
		logger.info("LOG -> {} -------->findStudentByFirstNameContaining ", logger.getName());
		return studentHelper.findStudentByFirstNameContaining(contains);
	}

	public List<Student> findStudentBasedOnGuardianName(String guardianName) {
		logger.info("LOG -> {} -------->findStudentBasedOnGuardianName ", logger.getName());
		return studentHelper.findStudentBasedOnGuardianName(guardianName);
	}

	public Student findStudentByEmailAddress(String emailId) {
		logger.info("LOG -> {} -------->findStudentByEmailAddress ", logger.getName());
		return studentHelper.findStudentByEmailAddress(emailId);
	}

	public String findStudentFirstNameByEmailAddress(String emailId) {
		logger.info("LOG -> {} -------->findStudentFirstNameByEmailAddress ", logger.getName());
		return studentHelper.findStudentFirstNameByEmailAddress(emailId);
	}

	public Student findStudentByEmailAddressNative(String emailId) {
		logger.info("LOG -> {} -------->findStudentByEmailAddressNative ", logger.getName());
		return studentHelper.findStudentByEmailAddressNative(emailId);
	}

	public Student findStudentByEmailAddressNativeNamedParam(String emailId) {
		logger.info("LOG -> {} -------->findStudentByEmailAddressNativeNamedParam ", logger.getName());
		return studentHelper.findStudentByEmailAddressNativeNamedParam(emailId);
	}

	public void updateStudentNameByEmailId(Student student) {
		logger.info("LOG -> {} -------->updateStudentNameByEmailId ", logger.getName());
		studentHelper.updateStudentNameByEmailId(student);
	}

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
		// studentRepository.save(student);
		return "Saved";
	}

}
