package com.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Backcontroller {
	@RequestMapping("/test")
	public String test() {
		return "返回provider2";
	}
	@RequestMapping("/user/{id}")
	public String user(@PathVariable("id") Integer id) {
		return "provider-two"+id;
	}

}
