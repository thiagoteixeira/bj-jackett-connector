package com.augustoteixeira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BjShareInterceptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BjShareInterceptorApplication.class, args);
		
		System.out.println("---------------------------------------");
		System.out.println("Bj-Share Jackett Connector");
		System.out.println("Status: Started");
		System.out.println("---------------------------------------");
	}
}
