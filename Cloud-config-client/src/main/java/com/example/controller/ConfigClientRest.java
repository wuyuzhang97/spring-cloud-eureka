package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {
	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServer;
	@Value("${server.port}")
	private String port;
	@RequestMapping("/conofig")
	public String getConfig() {
		String str = "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServer + "\t port: " + port;
		System.out.println("******str: " + str);
		
		return  "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServer + "\t port: " + port;
	}
}
