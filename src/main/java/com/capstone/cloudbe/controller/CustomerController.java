package com.capstone.cloudbe.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cloudbe.Domain.Customer;
import com.capstone.cloudbe.repository.CustomerRepository;
import com.microsoft.applicationinsights.TelemetryClient;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	TelemetryClient telemetryClient;
	
	@Autowired
	private CustomerRepository customerRepo;

	@GetMapping("/findAll")
	public ResponseEntity<List<Customer>> getTest() {
	    telemetryClient.trackEvent("URI /customer/findAll is triggered");
		return new ResponseEntity<>(customerRepo.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/")
	@Transactional
	public ResponseEntity<Customer> createTutorial(@RequestBody Customer newCustomer) {
		try {
			Customer entity = new Customer(newCustomer.getName(), newCustomer.getAddress());
			Customer customer = customerRepo
					.save(entity);
			return new ResponseEntity<>(customer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
