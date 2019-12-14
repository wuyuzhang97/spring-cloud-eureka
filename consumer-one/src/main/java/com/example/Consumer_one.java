package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@EnableEurekaClient
@EnableFeignClients//fegin集成了ribbon与熔断器
@EnableCircuitBreaker//对熔断机制的支持
@SpringBootApplication
public class Consumer_one {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Consumer_one.class, args);
	}

}
