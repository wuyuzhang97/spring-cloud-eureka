package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.netflix.ribbon.proxy.annotation.Hystrix;
@EnableEurekaClient
@SpringBootApplication
public class DeptProvider8002_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8002_App.class, args);
	}
}
