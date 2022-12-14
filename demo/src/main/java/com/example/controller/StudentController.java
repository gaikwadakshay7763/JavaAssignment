package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
@RequestMapping("/students")
 public List<Student> getAllStudent(){
	return studentService.getAllStudents();
}

/*
 * @RequestMapping("/students/{studintId}") public Student
 * getStudent(@PathVariable("studentId")String studentId ) { return
 * studentService.getStudent(studentId); }
 */

@PostMapping("/addStudent")
public void addStudent(@RequestBody Student student) {
	studentService.addStudent(student);
}


}
