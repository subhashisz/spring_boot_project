package com.myapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.model.Course;
import com.myapp.model.Teacher;

@SpringBootTest
class TeacherRepositoryTest {


	@Autowired
	private TeacherRepository teacherRepository;
	
	//@Test
	public void saveTeacher() {
		Course courseJava=Course.builder().credit(5).title("JAVA").build();
		Course courseJavascript=Course.builder().credit(3).title("JAVASCRIPT").build();
		Course courseScala=Course.builder().credit(4).title("SCALA").build();
		Course courseSparx=Course.builder().credit(4).title("SPARX").build();
		Course courseR=Course.builder().credit(4).title("R").build();
		Course coursePython=Course.builder().credit(4).title("PYTHON").build();
		
		Teacher teacher=Teacher.builder()
				.firstName("Suparna")
				.lastName("Sathyanarayana")
				//.courses(List.of(courseJava,courseJavascript,courseScala))
				.build();
		
		teacherRepository.save(teacher);
	}
}
