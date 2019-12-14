package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.service.FeginService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@RestController
public class Backcontroller {
	@Autowired
	private FeginService feginService;
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
	@RequestMapping("/user/{id}")
	public String user(@PathVariable("id") Integer id) {
		return feginService.user(id);
	}
	@RequestMapping("/get/{id}")
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public String get(@PathVariable("id") Long id) {
		RestTemplate rt = new RestTemplate();
		return rt.getForObject("http://127.0.0.1:9001/user/"+id, String.class);
	}
	public String processHystrix_Get(@PathVariable("id") Long id) {
		return "没有找到该id";
	}
}
