package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.Car;

public class CarService {
	
	private   Map<String,List<Car>> cars = new HashMap<>();
	
	
	public boolean isAvailable(String type) {
		synchronized(cars) {
			if(!cars.isEmpty()&& cars.containsKey(type)) {
				
				System.out.println(Thread.currentThread()+":This Car is available in Stock.");
				
				return true;
				
			}
			
			System.out.println(Thread.currentThread()+":This car is out of stock");
		
		return false;
	}
		}
	
	public void buyCar(String type) {

		synchronized(cars) {
		if (!cars.isEmpty()&&cars.containsKey(type)) {
			
			List<Car> carList = cars.remove(type);
			
			Car car = carList.remove(0);
			cars.put(type,carList);
			
			System.err.println(Thread.currentThread()+":Car is out of stock");
			
					
		}else {
			
			System.out.println(Thread.currentThread()+":Car is out of stock");
		}
		}
	}
	
	public void availableToBuy(String type) {
		
		synchronized(cars){
			
			while(cars.isEmpty()&&!cars.containsKey(type)) {
				
				try {
					cars.wait();
					
				}catch(InterruptedException e) {
					
					e.printStackTrace();
					
				}
			}
			System.out.println(Thread.currentThread()+":Car is now avaliable to buy");
		}
		
	}
	
	public void putStock(Car car) {
		
		synchronized(cars) {
			String type = "c"+car.getCarName()+"-t"+car.getId();
			
			if (cars.containsKey(car)) {
                     
				List<Car> carList = cars.get(0);
				
				carList.add(car);
				
				cars.put(type,carList);
			}
			else {
				List<Car> carList = new ArrayList<>();
				
				carList.add(car);
				
				cars.put(type, carList);
			}
			
			cars.notifyAll();
			
			System.out.println(Thread.currentThread()+":Car added to stock,Car is avaliable in stock");
		}
	}
	
	public void updateAvaliability(String type) {
		
		synchronized(cars) {
			while(cars.isEmpty()&&!cars.containsKey(type)) {
				try {
					System.out.println(Thread.currentThread()+":This car is out of stock . waiting for stock updates. ");
					
					cars.wait();
				}catch(InterruptedException e) {
					
					e.printStackTrace();
					
				}
			}
			
		System.out.println(Thread.currentThread()+":This car is now avaliable in stock");
		}
	}

}
