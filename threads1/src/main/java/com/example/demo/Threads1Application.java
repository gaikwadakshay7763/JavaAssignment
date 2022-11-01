package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Increment;

@SpringBootApplication
public class Threads1Application {

	public static void main(String[] args) {
		SpringApplication.run(Threads1Application.class, args);
		
		
		Increment mObj = new Increment();
		
		Thread t1 = new Thread(mObj, "thread 1");
		
		Thread t2 = new Thread(mObj, "thread 2");
		
		Thread t3 = new Thread(mObj, "thread 3");
		Thread t4 = new Thread(mObj,"thread 4");
		t1.start();
		t2.start();
		t4.start();
		t3.start();
	}

}
