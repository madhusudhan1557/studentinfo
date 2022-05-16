package com.myapp.student.request;

import lombok.Data;

@Data
public class CreateStudentRequest {
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private Long contact;
	private String faculty;

}
