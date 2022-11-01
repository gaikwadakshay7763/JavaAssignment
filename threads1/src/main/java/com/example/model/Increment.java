package com.example.model;

public class Increment implements Runnable{
	
	
		private int myVar=0;
		
		public int getMyVar(){
			
		return myVar;
		
		}
	public void setMyVar(int myVar) {
		  this.myVar = myVar;
		}
	public void increment() {
		  myVar++;
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	synchronized(this) {
		
	     this.increment();
		 System.out.println("Current thread being executed "+ Thread.currentThread().getName() + " Current Thread value " + this.getMyVar());
		}
	
	}
}


