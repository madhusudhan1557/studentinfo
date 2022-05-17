package com.myapp.student.entity;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.myapp.student.request.CreateFacultyRequest;
import com.myapp.student.request.UpdateFacultyRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "faculties", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fid;
	
	private String title;
	
	@OneToMany(mappedBy = "faculty", targetEntity = Course.class)
	private List<Course> course;
	
	@OneToMany(mappedBy = "faculty", targetEntity = Course.class)
	private List<Student> student;
	
	public Faculty(CreateFacultyRequest facultyRequest) {
		this.title = facultyRequest.getTitle();
	}
	public Faculty(UpdateFacultyRequest facultyRequest) {
		this.title = facultyRequest.getTitle();
	}
}
