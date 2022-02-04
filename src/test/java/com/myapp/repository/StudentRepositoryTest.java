package com.myapp.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.model.Guardian;
import com.myapp.model.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent() {
		Student student = Student.builder().emailId("sample@gmail.com").firstName("samle").lastName("lastname").build();
		studentRepository.save(student);
	}

	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder().email("nikhil@gmail.com").name("Nikhil").mobile("9999956324").build();
		Student student = Student.builder().firstName("Shivam").emailId("shivam@gmail.com").lastName("Kumar").guardian(guardian).build();
		studentRepository.save(student);

	}

	@Test
	public void printAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println("studentList = " + studentList);
	}

	@Test
	public void printStudentByFirstName() {
		List<Student> students = studentRepository.findByFirstName("shivam");
		System.out.println("students = " + students);
	}

	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> students = studentRepository.findByFirstNameContaining("sh");
		System.out.println("students = " + students);
	}

	@Test
	public void printStudentBasedOnGuardianName() {
		List<Student> students = studentRepository.findByGuardianName("Nikhil");
		System.out.println("students = " + students);
	}

	@Test
	public void printgetStudentByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("sample@gmail.com");
		System.out.println("student = " + student);
	}

	@Test
	public void printgetStudentFirstNameByEmailAddress() {
		String firstName = studentRepository.getStudentFirstNameByEmailAddress("shivam@gmail.com");
		System.out.println("firstName = " + firstName);
	}

	@Test
	public void printgetStudentByEmailAddressNative() {
		Student student = studentRepository.getStudentByEmailAddressNative("shivam@gmail.com");
		System.out.println("student = " + student);
	}

	@Test
	public void printgetStudentByEmailAddressNativeNamedParam() {
		Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("shivam@gmail.com");
		System.out.println("student = " + student);
	}

	@Test
	public void updateStudentNameByEmailIdTest() {
		studentRepository.updateStudentNameByEmailId("sample","sample", "sample@gmail.com");
	}

}
