package com.daruedo.projectspringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalcController {
	@GetMapping("/somar/{a}/{b}")
	public int sum(@PathVariable int a,@PathVariable int b) {
		return a + b;
	}

	@GetMapping("/subtract")
	public int subtract(@RequestParam(name = "a") int a,@RequestParam(name = "b") int b) {
		return a - b;
	}
}
