package com.myapp.student.response;

import com.myapp.student.entity.Faculty;

import lombok.Data;

@Data
public class FacultyResponse {
	private Long fid;
	private String title;
 
	
	public FacultyResponse(Faculty faculty) {
		this.fid = faculty.getFid();
		this.title = faculty.getTitle();
		
	}
}
