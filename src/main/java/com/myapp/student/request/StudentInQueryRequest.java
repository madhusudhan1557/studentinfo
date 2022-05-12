package com.myapp.student.request;

import java.util.List;

import lombok.Data;

@Data
public class StudentInQueryRequest {
 private List<String> firstnames;
}
