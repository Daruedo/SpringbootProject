package com.daruedo.projectspringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daruedo.projectspringboot.model.entities.Client;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@GetMapping("/any")
	public Client obtainClient() {
		return new Client(28, "Pedro", "123.456.789-00");
	}
	
	@GetMapping("/{id}")
	public Client obtainClientById1(@PathVariable int id) {
		return new Client(id, "Maria", "987.654.321-99");
	}
	@GetMapping
	public Client obtainClientById2(@RequestParam(name ="id", defaultValue = "1") int id) {
		return new Client(id, "João Augusto", "111.222.333-44");
	}
}
