package com.myapp.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myapp.model.Student;
import com.myapp.service.StudentService;

@Component
public class StudentHelper {

	Logger logger = LoggerFactory.getLogger(StudentHelper.class);
	
	@Autowired
	private StudentService studentService;

	public Student saveStudent(Student student) {
		logger.info("LOG -> {} -------->saveStudent ", logger.getName());
		return studentService.saveStudent(student);
	}

	public Student saveStudentWithGuardian(Student student) {
		logger.info("LOG -> {} -------->saveStudentWithGuardian ", logger.getName());
		return studentService.saveStudentWithGuardian(student);

	}

	public List<Student> findAllStudent() {
		logger.info("LOG -> {} -------->findAllStudent ", logger.getName());
		return studentService.findAllStudent();
	}

	public List<Student> findStudentByFirstName(String firstName) {
		logger.info("LOG -> {} -------->findStudentByFirstName ", logger.getName());
		return studentService.findStudentByFirstName(firstName);
	}

	public List<Student> findStudentByFirstNameContaining(String contains) {
		logger.info("LOG -> {} -------->findStudentByFirstNameContaining ", logger.getName());
		return studentService.findStudentByFirstNameContaining(contains);
	}

	public List<Student> findStudentBasedOnGuardianName(String guardianName) {
		logger.info("LOG -> {} -------->findStudentBasedOnGuardianName ", logger.getName());
		return studentService.findStudentBasedOnGuardianName(guardianName);
	}

	public Student findStudentByEmailAddress(String emailId) {
		logger.info("LOG -> {} -------->findStudentByEmailAddress ", logger.getName());
		return studentService.findStudentByEmailAddress(emailId);
	}

	public String findStudentFirstNameByEmailAddress(String emailId) {
		logger.info("LOG -> {} -------->findStudentFirstNameByEmailAddress ", logger.getName());
		return studentService.findStudentFirstNameByEmailAddress(emailId);
	}

	public Student findStudentByEmailAddressNative(String emailId) {
		logger.info("LOG -> {} -------->findStudentByEmailAddressNative ", logger.getName());
		return studentService.findStudentByEmailAddressNative(emailId);
	}

	public Student findStudentByEmailAddressNativeNamedParam(String emailId) {
		logger.info("LOG -> {} -------->findStudentByEmailAddressNativeNamedParam ", logger.getName());
		return studentService.findStudentByEmailAddressNativeNamedParam(emailId);
	}

	public void updateStudentNameByEmailId(Student student) {
		logger.info("LOG -> {} -------->updateStudentNameByEmailId ", logger.getName());
		studentService.updateStudentNameByEmailId(student);
	}

}
