package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class Backcontroller {
	@Autowired
	private LoadBalancerClient LoadBalancerClient;
	@RequestMapping("/test")
	public String test() {
		ServiceInstance choose = LoadBalancerClient.choose("provider");
		//拼接访问服务的 URL 
		StringBuffer sb = new StringBuffer(); 
		sb.append("http://").append(choose.getHost()+":").append(choose.getPort()+"/test");
		//springMVC RestTemplate
		RestTemplate rt = new RestTemplate();
		ParameterizedTypeReference<String> type = new ParameterizedTypeReference<String>() {};
		//rt.exchange(sb, HttpMethod.GET, null, type);
		ResponseEntity<String> response =rt.exchange(sb.toString(), HttpMethod.GET, null, type);
		return response.getBody();
	}
}
