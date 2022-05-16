package com.myapp.student.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.myapp.student.request.CreateStudentRequest;
import com.myapp.student.request.UpdateStudentRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Firstname is Required")
	private String firstname;

	private String lastname;

	@NotBlank(message = "Email is Required")
	@Email(message = "Email must be Valid")
	private String email;

	private String address;

	private Long contact;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fid", referencedColumnName = "fid", insertable = true)
	private Faculty faculty;

	public Student(CreateStudentRequest studentRequest) {
		this.firstname = studentRequest.getFirstname();
		this.lastname = studentRequest.getLastname();
		this.email = studentRequest.getEmail();
		this.address = studentRequest.getAddress();
		this.contact = studentRequest.getContact();
	}

	public Student(UpdateStudentRequest studentRequest) {
		this.firstname = studentRequest.getFirstname();
		this.lastname = studentRequest.getLastname();
		this.email = studentRequest.getEmail();
		this.address = studentRequest.getAddress();
		this.contact = studentRequest.getContact();
	}
}
