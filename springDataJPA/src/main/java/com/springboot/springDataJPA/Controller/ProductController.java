package com.springboot.springDataJPA.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springDataJPA.Entity.Product;
import com.springboot.springDataJPA.Repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping
	public Iterable<Product> getProducts(){
		return this.productRepository.findAll();
	}
	
	@GetMapping("/{productId}")
	public Optional<Product> getProduct(@PathVariable("productId") Integer productId) {
		return this.productRepository.findById(productId);
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return this.productRepository.save(product);
	}
	
	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return this.productRepository.save(product);
	}
	
	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable("productId") Integer productId) {
		this.productRepository.deleteById(productId);
	}
}
