package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import com.example.demo.Student;
import com.example.demo.Teacher;
import com.example.headers.CustomHeaders;

@Service

public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private CustomHeaders customheaders;

	//private static Map<Long, Student> students = new HashMap<>();
	HttpHeaders headers = new HttpHeaders();
	
	private   ArrayList<Student> students = new ArrayList<>();
	
	
	  { Student student1 = new Student(1, "Akshay", "222222222", 25L,5L); Student
	  student2 = new Student(2, "Nikhil", "888888888", 50L,7L);
	  
	  students.add( student1); 
	  students.add(student2);
	  
	  }
	

  
	@Override
	public List<Student> getAllStudents() {
		return new ArrayList<>(students);
	}
	
    @Override
	public Student getStudentDetails(int studentId) {
		return students.get(studentId);
	}
    
    @Override
	public Student addStudent(Student student) {
		//index ++;

		student.setStudentId(students.size()+1);
		students.add(student);
		return student;
	}
	
	@Override
	  public List<Student> addMultipleStudent(Student student){ 
	  
		  int [] studentId = {3,4,5,6,7,8,9,10,12,13,};
		  String[] name = {"Shubham","Ganesh","Nehit","Alka","Prajit","Pranav","Ajinkya","Pradip","Vishal","Omkar"};
		  String[] address = {"pune","solapur","nagpur","Latur","Dharashiv","Kolhapur","Nashik","Mumbai","Thane","Satara"};
		  Long[]age= {25L,25L,25L,25L,25L,25L,25L,25L,25L,25L};
		  Long[]standred= {5L,6L,7L,5L,6L,7L,5L,6L,7L,5L};
		  
		       Random random = new Random();
		  
		       
		       for(int i= 0;i<random.nextInt(9);i++) {	   
		    	   
		    	   Student studentMultiple = new Student(studentId[i],name[i],address[i],age[i],standred[i]);
		    	   studentMultiple.setStudentId(students.size()+1);
		    	   students.add( studentMultiple);
		    	   
		       } 
		     
		       student.setStudentId(students.size()+1);
		       students.add(student);
		       
		       
		       return new ArrayList<>(students);

	
	
	}
	
	@Override
	 public Student removeStudent( int studentId) {
		
		 students.removeIf(students ->students.getStudentId()== studentId);
		 
		      return students.get(studentId) ;
		}
	 
	 
	  public Student getTeacherDetails(Long standred) {
		  
		  return students.stream().filter(student -> student.getStandred().equals(standred)).findAny().orElse(null);
	  }
	  
	  public List<String> header(){
		  
			return headers.get("Authorization");
			
		}
	  
	  
	  public void addHeader( String token) {
		  
		  headers.add("Authorization", "Bearer"+" "+ token);
	  }
	  
	  public List<String> getHeaders() {
		  return headers.get("Authorization");
	  }
	  
}

