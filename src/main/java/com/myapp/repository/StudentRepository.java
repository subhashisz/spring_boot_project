package com.myapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myapp.controller.StudentController;
import com.myapp.model.Student;

import lombok.extern.slf4j.Slf4j;

import static com.myapp.constants.AppQueries.GET_STUDENT_BY_EMAIL_ADDRESS;
import static com.myapp.constants.AppQueries.GET_STUDENT_FIRST_NAME_BY_EMAIL_ADDRESS;
import static com.myapp.constants.AppQueries.GET_STUDENT_BY_EMAIL_ADDRESS_NATIVE;
import static com.myapp.constants.AppQueries.GET_STUDENT_BY_EMAIL_ADDRESS_NATIVE_NAMED_PARAM;
import static com.myapp.constants.AppQueries.UPDATE_STUDENT_NAME_BY_EMAILID;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByFirstName(String firstName);

	public List<Student> findByFirstNameContaining(String name);

	public List<Student> findByLastNameNotNull();

	public List<Student> findByGuardianName(String guardianName);

	public Student findByFirstNameAndLastName(String firstName, String lastName);

	// JPQL
	@Query(GET_STUDENT_BY_EMAIL_ADDRESS)
	public Student getStudentByEmailAddress(String emailId);

	// JPQL
	@Query(GET_STUDENT_FIRST_NAME_BY_EMAIL_ADDRESS)
	public String getStudentFirstNameByEmailAddress(String emailId);

	// Native
	@Query(value = GET_STUDENT_BY_EMAIL_ADDRESS_NATIVE, nativeQuery = true)
	public Student getStudentByEmailAddressNative(String emailId);

	// Native Named Param
	@Query(value = GET_STUDENT_BY_EMAIL_ADDRESS_NATIVE_NAMED_PARAM, nativeQuery = true)
	public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

	@Modifying
	@Transactional
	@Query(value = UPDATE_STUDENT_NAME_BY_EMAILID, nativeQuery = true)
	public int updateStudentNameByEmailId(String firstName, String lastName, String emailId);

}
