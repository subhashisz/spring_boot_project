package com.myapp.constants;

public interface AppQueries {

	public static String GET_STUDENT_BY_EMAIL_ADDRESS = "select s from Student s where s.emailId = ?1";
	public static String GET_STUDENT_FIRST_NAME_BY_EMAIL_ADDRESS = "select s.firstName from Student s where s.emailId = ?1";
	public static String GET_STUDENT_BY_EMAIL_ADDRESS_NATIVE = "SELECT * FROM tbl_student s where s.email_address = ?1";
	public static String GET_STUDENT_BY_EMAIL_ADDRESS_NATIVE_NAMED_PARAM = "SELECT * FROM tbl_student s where s.email_address = :emailId";
	public static String UPDATE_STUDENT_NAME_BY_EMAILID = "update tbl_student set first_name = ?1 , last_name = ?2 where email_address = ?3";

}
