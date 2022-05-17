package com.myapp.student.service;

import java.util.List;

import com.myapp.student.entity.Faculty;

public interface FacultyService {

	List<Faculty> getAllFaculty();

	Faculty getFacultyById(Long fid);

}
