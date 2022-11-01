package com.example.model;

public class Car {
	
	int id;
	String carName;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Car(int id, String carName) {
		super();
		this.id = id;
		this.carName = carName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	

}
