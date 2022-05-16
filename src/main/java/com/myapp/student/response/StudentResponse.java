package com.myapp.student.response;

import com.myapp.student.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {
	
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private Long contact;
	private String faculty;
	
	public StudentResponse(Student student) {
		this.id = student.getId();
		this.firstname = student.getFirstname();
		this.lastname = student.getLastname();
		this.email = student.getEmail();
		this.address = student.getAddress();
		this.contact = student.getContact();
		this.faculty = student.getFaculty().getTitle();
	}
}
