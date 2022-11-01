package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Car;
import com.example.service.CarService;

@SpringBootApplication
public class Test2Application{

	public static void main(String[] args) {
		SpringApplication.run(Test2Application.class, args);
		
		
		CarService carService = new CarService();
		
		
		Thread t1Thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				String type = "cSUV-tSport";
				
               
				
				carService.updateAvaliability(type);
				
			}
			
		},"t1Thred");
		
		t1Thread.start();

		
		Thread buyerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String type = "cSUV-tSport";
				
				if(carService.isAvailable(type)) {
					carService.buyCar(type);
				}
			}
			
		},"BuyerThread");
		
		buyerThread.start();
		
		
		Thread SellerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String type ="cSUV-tSport";
				
				Car car = new Car(1,"Safari");
				
				carService.putStock(car);
				
			
			}
			
		},"sellerThread");
		
		SellerThread.start();
		
	}
	
	
	


//sellerThread.start();
	

}
	
	//Thread sellerThread = new Thread(new Runnable() {

		///@Override
		//public void run() {
			// TODO Auto-generated method stub
		//	String type = "cSuv-tSport";
			
		//	Car car = new Car(1,"Safari");
			
		//	carService.putStock(car);
		//}
		
	//},"SellerThread");
	
	

	
	


