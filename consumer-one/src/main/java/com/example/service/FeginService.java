package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider")
public interface FeginService {
	@GetMapping("/user/{id}")
	public String user(@PathVariable("id") Integer id);
}
