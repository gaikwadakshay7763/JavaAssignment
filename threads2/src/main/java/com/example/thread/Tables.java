package com.example.thread;

public class Tables extends Thread{
	
	int a;



	public Tables(int a) {
		super();
		this.a = a;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	
	public   void run() {
		
		
		System.out.println("Table of "+a);
	  
			
		
		for (int n=1; n<11 ;n++) {
			
			int product = a * n;
			
			
			System.out.println(product);
			
			
			
		
			
		
		}
	}
	
}
