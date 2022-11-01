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
	 // private  int index = 1;

  
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
		 
		  
           //index++;
			//student.setStudentId(index);
		 
	  
		  int [] studentId = {3,4,5,6,7,8,9,10,12,13,};
		  String[] name = {"Shubham","Ganesh","Nehit","Alka","Prajit","Pranav","Ajinkya","Pradip","Vishal","Omkar"};
		  String[] address = {"pune","solapur","nagpur","Latur","Dharashiv","Kolhapur","Nashik","Mumbai","Thane","Satara"};
		  Long[]age= {25L,25L,25L,25L,25L,25L,25L,25L,25L,25L};
		  Long[]standred= {5L,6L,7L,5L,6L,7L,5L,6L,7L,5L};
		  
		       Random random = new Random();
		  
		       
		       for(int i= 0;i<random.nextInt(9);i++) {
		    	   
		    	  // index ++;
		    	   
		    	   
		    	   
		    	   
		    	   Student studentMultiple = new Student(studentId[i],name[i],address[i],age[i],standred[i]);
		    	   studentMultiple.setStudentId(students.size()+1);
		    	   students.add( studentMultiple);
		    	   
		       } 
		     
		       student.setStudentId(students.size()+1);
		       students.add(student);
		       
		       
		       return new ArrayList<>(students);
	  
		    	   
		       
			/*
			 * Student newList1 = new Student(3L, "Akshay", "222222222", 25L); Student
			 * newList2 = new Student(4L, "Nikhil", "888888888", 50L); Student newList3 =
			 * new Student(5L, "Bhavesh", "888888888", 50L); Student newList4 = new
			 * Student(6L, "Vilas", "888888888", 50L); Student newList5 = new Student(7L,
			 * "Satish", "888888888", 50L); Student newList6 = new Student(8L, "Pranav",
			 * "888888888", 50L); Student newList7 = new Student(9L, "Ganesh", "888888888",
			 * 50L); Student newList8 = new Student(10L, "Nikhil", "888888888", 50L);
			 * Student newList9 = new Student(11L, "Nikhil", "888888888", 50L); Student
			 * newList10 = new Student(12L, "Nikhil", "888888888", 50L); Student newList11 =
			 * new Student(12L, "Nikhil", "888888888", 50L);
			 */
	  
			/*
			 * newList.put(1L, newList1); newList.put( 2L,newList2); newList.put(
			 * 3L,newList3); newList.put(4L, newList4); newList.put(5L, newList5);
			 * newList.put( 6L,newList6); newList.put( 7L,newList7); newList.put(8L,
			 * newList8); newList.put(9L, newList9); newList.put(10L,newList10);
			 * newList.put(10L,newList11);
			 */
	  
	  
	  
	  
	  //Predicate<Student> pr= (index) ->(index > random.nextInt(10));
	  //newList.remove(pr);
	  
	  /*for(int i= newList.size();i>random.nextInt(10);i--) { newList.remove(i); }
	  
	  students.putAll(newList);
	  
	  index++;
	  
	  students.put(index, student);
	  
	  return new ArrayList<>(students.values());
	  
	  }*/
	 

	
	/**/
	  
	/*
	 * public void removeStudent(Long studentId) { students.removeIf(student
	 * ->students.getStudentId().equals(studentId)); }
	 */
	  
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

