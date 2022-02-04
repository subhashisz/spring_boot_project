package com.myapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.model.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;

	@Test
	void saveStudent() {
		Student student=Student.builder()
				.firstName("venkat1")
				.lastName("babu1")
				.emailId("venkat1@email.com")
				.build();
		studentRepository.save(student);
				
			

	}

}
