package com.daruedo.projectspringboot.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daruedo.projectspringboot.model.entities.Product;
import com.daruedo.projectspringboot.model.repositories.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(method= {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Product newProduct(@Valid Product product) {
		productRepository.save(product);
		return product;
	}
	
	@GetMapping
	public Iterable<Product> showProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping(path="/name/{partName}")
	public Iterable<Product> showProductsByName(@PathVariable String partName) {
//		return productRepository.findByNameContainingIgnoreCase(partName);
		return productRepository.searchByNameLike(partName);
	}
	
	@GetMapping(path="/page/{numPage}/{qtyPage}")
	public Iterable<Product> showProductByPage(@PathVariable int numPage, @PathVariable int qtyPage) {
		if(qtyPage >=5) qtyPage=5;
		Pageable page = PageRequest.of(numPage, qtyPage);
		return productRepository.findAll(page);
	}
	
	@GetMapping(path="/{id}")
	public Optional<Product> showProductByID(@PathVariable int id) {
		return productRepository.findById(id);
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteProduct(@PathVariable int id) {
		productRepository.deleteById(id);
	}
}
