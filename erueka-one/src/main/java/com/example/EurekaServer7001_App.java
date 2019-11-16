package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7001_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(EurekaServer7001_App.class, args);
	}

}
