package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@RequestMapping("/index1")
	String index1()
	{
		return "Welcome1";
		
	}
	@RequestMapping("/index2")
	String index2()
	{
		return "Welcome2";
		
	}

}
