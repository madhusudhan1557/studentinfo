package com.myapp.student.request;

import lombok.Data;

@Data
public class UpdateStudentRequest {
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private Long contact;
}
