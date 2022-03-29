package com.auth.webservice.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.webservice.entity.User;
import com.auth.webservice.repository.UserRepository;
import com.auth.webservice.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	UserService useService;
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") long id) {
		Optional<User> user = userRepo.findById(id);
		if (user != null) {
			LOGGER.info("User is found with id :: "+id);
			return user;
		}
		LOGGER.info("User is not found with id "+id);
		throw new UsernameNotFoundException("User Not Found For Given id" + id);
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> list = userRepo.findAll();
		if (list.isEmpty()) {
			LOGGER.info("User is not found , user list is empty ");
			throw new UsernameNotFoundException("User Not Found ");
		}
		LOGGER.info("Get users list is successfull");
		return list;
	}

	@PostMapping("/users")
	public User addUser(@Valid @RequestBody User user) {
		return userRepo.save(user);
	}

	@PostMapping("/users/register")
	public User register(@Valid @RequestBody User user) {
		return useService.register(user);
	}
	
	@PutMapping("/users")
	public User updateUser(@Valid @RequestBody User user) {
		return userRepo.save(user);
	}

	@DeleteMapping("/users/{id}")
	public String deleteUserById(@Valid @PathVariable("id") long id) {
		userRepo.deleteById(id);
		return "User Delete Succesfully ";
	}
}
