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

import com.auth.webservice.entity.Employee;
import com.auth.webservice.exception.EmployeeNotFound;
import com.auth.webservice.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") long id) {
		Optional<Employee> emp = empRepo.findById(id);
		if (emp != null) {
			return emp;

		}
		throw new EmployeeNotFound("Employee not found with Given Id " + id);

	}

	@GetMapping("/employees")
	public List<Employee> getEmployee() {
		List<Employee> list = empRepo.findAll();
		if (list.isEmpty()) {
			throw new EmployeeNotFound("employee List Is Empty No Data Found");
		}
		return list;
	}

	@GetMapping("/employee")
	public List<Employee> getEmployeeByName(@RequestParam("name") String name) {
		return empRepo.findByName(name);

	}

	@PostMapping("/employee")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return empRepo.save(employee);

	}

	@PutMapping("/employee")
	public Employee updateEmployee(@Valid @RequestBody Employee emp) {
		return empRepo.save(emp);
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployeerById(@Valid @PathVariable("id") long id) {
		empRepo.deleteById(id);
		return "Customer Delete SuccesFull";
	}

}
