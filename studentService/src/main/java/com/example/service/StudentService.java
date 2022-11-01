package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Student;

public interface StudentService {
	
	
	
	public default List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
	
	public Student addStudent(Student student);
	
	public Student getStudentDetails(int studentId);
	
	public Student getTeacherDetails(Long standred);
	
	public List<String> header();
	
	
	public List<Student> addMultipleStudent(Student student);

	public void addHeader(String token);
	
	public List<String> getHeaders();

	public Student removeStudent(int studentId);

}
