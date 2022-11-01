package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.thread.Tables;

@SpringBootApplication
public class Threads2Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Threads2Application.class, args);
		
		Tables t1 = new Tables(5);
		Tables t2 = new Tables(4);
		t1.start();
		
		t1.sleep(100);
		
		t2.start();
		try {
		t1.join();
		t2.join();
		}catch(Exception e) {
			
			System.out.println("Interrupted");
		}
	}

}
