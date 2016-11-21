package com.augustoteixeira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.augustoteixeira.services.Interceptor;

@SpringBootApplication
public class BjShareInterceptorApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BjShareInterceptorApplication.class, args);
		
		System.out.println("---------------------------------------");
		System.out.println("Bj-Share Jackett Connector");
		System.out.println("Status: Started");
		System.out.println("---------------------------------------");
	}
	
	/**
     * Used when run as WAR
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Interceptor.class);
    }
}
