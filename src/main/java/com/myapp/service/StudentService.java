package com.myapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.helper.StudentHelper;
import com.myapp.model.Guardian;
import com.myapp.model.Student;
import com.myapp.repository.StudentRepository;

@Service
public class StudentService {
	
	Logger logger = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student student) {
		logger.info("LOG -> {} -------->saveStudent ", logger.getName());
		Student.builder().emailId(student.getEmailId()).firstName(student.getFirstName())
				.lastName(student.getLastName()).build();
		return studentRepository.save(student);
	}

	public Student saveStudentWithGuardian(Student student) {
		logger.info("LOG -> {} -------->saveStudentWithGuardian ", logger.getName());
		Student.builder().firstName(student.getFirstName()).lastName(student.getLastName())
				.emailId(student.getEmailId()).guardian(Guardian.builder().email(student.getGuardian().getEmail())
						.name(student.getGuardian().getName()).mobile(student.getGuardian().getMobile()).build())
				.build();
		return studentRepository.save(student);

	}

	public List<Student> findAllStudent() {
		logger.info("LOG -> {} -------->findAllStudent ", logger.getName());
		return studentRepository.findAll();
	}

	public List<Student> findStudentByFirstName(String firstName) {
		logger.info("LOG -> {} -------->findStudentByFirstName ", logger.getName());
		return studentRepository.findByFirstName(firstName);
	}

	public List<Student> findStudentByFirstNameContaining(String contains) {
		logger.info("LOG -> {} -------->findStudentByFirstNameContaining ", logger.getName());
		return studentRepository.findByFirstNameContaining(contains);
	}

	public List<Student> findStudentBasedOnGuardianName(String guardianName) {
		logger.info("LOG -> {} -------->findStudentBasedOnGuardianName ", logger.getName());
		return studentRepository.findByGuardianName(guardianName);
	}

	public Student findStudentByEmailAddress(String email) {
		logger.info("LOG -> {} -------->findStudentByEmailAddress ", logger.getName());
		return studentRepository.getStudentByEmailAddress(email);
	}

	public String findStudentFirstNameByEmailAddress(String email) {
		logger.info("LOG -> {} -------->findStudentFirstNameByEmailAddress ", logger.getName());
		return studentRepository.getStudentFirstNameByEmailAddress(email);
	}

	public Student findStudentByEmailAddressNative(String email) {
		logger.info("LOG -> {} -------->findStudentByEmailAddressNative ", logger.getName());
		return studentRepository.getStudentByEmailAddressNative(email);
	}

	public Student findStudentByEmailAddressNativeNamedParam(String email) {
		logger.info("LOG -> {} -------->findStudentByEmailAddressNativeNamedParam ", logger.getName());
		return studentRepository.getStudentByEmailAddressNativeNamedParam(email);
	}

	public int updateStudentNameByEmailId(Student student) {
		logger.info("LOG -> {} -------->updateStudentNameByEmailId ", logger.getName());
		return studentRepository.updateStudentNameByEmailId(student.getFirstName(), student.getLastName(), student.getEmailId());
	}

}
