package com.myapp.student.service;

import java.util.List;

import com.myapp.student.entity.Faculty;
import com.myapp.student.request.CreateFacultyRequest;
import com.myapp.student.request.UpdateFacultyRequest;

public interface FacultyService {

	List<Faculty> getAllFaculty();

	Faculty getFacultyById(Long fid);

	Faculty createFaculty(CreateFacultyRequest facultyRequest);

	Faculty updateFaculty(UpdateFacultyRequest facultyRequest, Long fid);

}
