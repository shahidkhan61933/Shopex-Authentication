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

import com.auth.webservice.entity.Order;
import com.auth.webservice.exception.OrderNotFound;
import com.auth.webservice.repository.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	OrderRepository orderRepo;

	@GetMapping("/orders/{id}")
	public Optional<Order> getOrderById(@PathVariable("id") long id) {
		Optional<Order> order = orderRepo.findById(id);
		if (order != null) {
			return order;
		}
		throw new OrderNotFound("Order Not Found For Given id" + id);
	}

	@GetMapping("/order")
	public List<Order> orderByName(@RequestParam("ordername") String ordername) {
		return orderRepo.findByName(ordername);
	}

	@GetMapping("/orders")
	public List<Order> getOrders() {
		List<Order> list = orderRepo.findAll();
		if (list.isEmpty()) {
			throw new OrderNotFound("Order Not Found ");
		}
		return list;
	}

	@PostMapping("/order")
	public Order addOrder(@Valid @RequestBody Order order) {
		return orderRepo.save(order);

	}

	@PutMapping("/order")
	public Order updateOrder(@Valid @RequestBody Order order) {
		return orderRepo.save(order);

	}

	@DeleteMapping("/order/{id}")
	public String deleteOrderById(@Valid @PathVariable("id") long id) {
		orderRepo.deleteById(id);
		return "Product Delete Succesfully ";
	}
}
