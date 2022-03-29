package com.auth.webservice.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.webservice.entity.Product;
import com.auth.webservice.exception.ProductNotFoundexception;
import com.auth.webservice.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepo;

	@GetMapping("/products/{id}")
	public Optional<Product> getProductById(@PathVariable("id") long id) {
		Optional<Product> product = productRepo.findById(id);
		if (product != null) {
			return product;
		}
		throw new ProductNotFoundexception("Product is Not Found With Given Name" + id);
	}

	@GetMapping("/product")
	public Optional<Product> getProductByName(@RequestParam("name") String name) {
		return productRepo.findByName(name);

	}

	@GetMapping("/products")
	public List<Product> getProducts() {
		List<Product> list = productRepo.findAll();
		if (list.isEmpty()) {
			throw new ProductNotFoundexception("Product List is Empty,Zero Record Found ");
		}
		return list;
	}

	@PostMapping("/product")
	public Product addProducts(@Valid @RequestBody Product product) {
		return productRepo.save(product);
	}

	@PutMapping("/product")
	public Product updeteProduct(@Valid@RequestBody Product product) {
		return productRepo.save(product);
	}

	@DeleteMapping("/product/{id}")
	public String deleteProductById(@Valid @PathVariable("id") long id) {
		productRepo.deleteById(id);
		return "Product Delete Succesfully ";
	}

}
