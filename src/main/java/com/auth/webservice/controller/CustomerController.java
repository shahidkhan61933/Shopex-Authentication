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

import com.auth.webservice.entity.Customer;
import com.auth.webservice.exception.CustomerNotFound;
import com.auth.webservice.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepository custRepository;

	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") long id) {
		Optional<Customer> cust = custRepository.findById(id);
		if (cust != null) {
			return cust;

		}
		throw new CustomerNotFound("Customer Nit found with Given Id " + id);

	}

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		List<Customer> list = custRepository.findAll();
		if (list.isEmpty()) {
			throw new CustomerNotFound("Customer List Is Empty No Data Found");
		}
		return list;
	}

	@GetMapping("/customer")
	public List<Customer> getcustomerByName(@RequestParam("name") String name) {
		return custRepository.findByName(name);

	}

	@PostMapping("/customer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return custRepository.save(customer);
	}

	@PutMapping("/customer")
	public Customer updateCustomer(@Valid @RequestBody Customer customer) {
		return custRepository.save(customer);
	}

	@DeleteMapping("/customer/{id}")
	public String deleteCustomerById(@Valid @PathVariable("id") long id) {
		custRepository.deleteById(id);
		return "Customer Delete SuccesFull";
	}

	@GetMapping("/cust")
	public List<Customer> getcustomerByEmail(@RequestParam("email") String email) {
		return custRepository.findByEmail(email);
	}

}
