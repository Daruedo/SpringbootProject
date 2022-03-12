package com.daruedo.projectspringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	@GetMapping(path = {"/hello","/salute"})
	public String hello() {
		return "Hello World";
	}

}
