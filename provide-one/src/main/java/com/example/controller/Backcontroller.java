package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Backcontroller {
	@RequestMapping("/test")
	public String test() {
		return "返回provider1";
	}
}
