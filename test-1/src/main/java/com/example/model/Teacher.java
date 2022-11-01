package com.example.model;

public class Teacher {
	
	private int teacherId;
	private String teacherName;
	
	private Long standred;
	
    public Teacher(int teacherId, String teacherName, Long standred) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.standred = standred;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Long getStandred() {
		return standred;
	}

	public void setStanderd(Long standerd) {
		this.standred = standerd;
	}


	
    
   
}
