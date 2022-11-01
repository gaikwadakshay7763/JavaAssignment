package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private int studentId;
	private String name;
	private String address;
	private Long age;
	private Long standred;
	
	List<Teacher> teachers = new ArrayList<>();
	
	
     public Student() {
		
	   }
	
	public Student(int studentId, String name, String address, Long age,Long standred, List<Teacher> teachers) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.address = address;
		this.age = age;
		this.standred= standred;
		this.teachers = teachers;
	}

	

	public Student(int studentId, String name, String address, Long age,Long standred) {
		this.studentId = studentId;
		this.name = name;
		this.address = address;
		this.age = age;
		this.standred= standred;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}
	public Long getStandred() {
		return standred;
	}

	public void setStandred(Long standred) {
		this.standred = standred;
	}
	
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeacher(List<Teacher> teachers) {
		this.teachers = teachers;
	}


	
	
	

}
