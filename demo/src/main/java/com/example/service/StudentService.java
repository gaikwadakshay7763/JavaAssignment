package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.entity.Student;

@Service
public class StudentService {

	 private List<Student> studentList = new ArrayList<>();
	 
	 
	 
	 /*(Arrays.asList(

	            new Student(1,"_spring", "_Spring FrameWork", "_Spring Description",35),
	            new Student(2,"spring", "Spring FrameWork", "Spring Description",28),
	            new Student(3,"java", "Java FrameWork", "Java Description",25)

	    ));*/
	 
	 public List<Student> getAllStudents(){
		 
		 return studentList;
	 }
	 
	 public void addStudent(Student student) {
		 
		     studentList.add(student);
		 
	 }
	 
		/*
		 * public void getStudent(String studentId) { return
		 * studentList.stream().filter(student ->
		 * student.getStudentId()equals(studentId).findFirst().get()); }
		 */
	 private int generateOTP(String username) {

			Random random = new Random();
			int sentOTP = random.nextInt(99);
           
			String subject = "OTP for Login";
			String recipient = username;
			String body = "OTP : " + sentOTP;

			studentList.add(new Student(1,subject, recipient, body,2));

			return sentOTP;

		}
	
}
