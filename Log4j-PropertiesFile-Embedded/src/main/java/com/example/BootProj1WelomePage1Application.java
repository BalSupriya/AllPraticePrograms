package com.example;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootProj1WelomePage1Application {
	public static final Logger logger=Logger.getLogger("BootProj1WelomePage1Application.class");

	public static void main(String[] args) {
		
		
		SpringApplication.run(BootProj1WelomePage1Application.class, args);
	      	logger.info("main method start");
	      	System.out.println(".........");
		
	
	}

}
