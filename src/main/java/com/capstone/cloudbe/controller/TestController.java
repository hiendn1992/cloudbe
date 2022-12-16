package com.capstone.cloudbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.applicationinsights.TelemetryClient;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	TelemetryClient telemetryClient;

	@GetMapping("/")
	public ResponseEntity<?> getTest() {
		// send event
	    telemetryClient.trackEvent("URI /test is triggered");
		return new ResponseEntity<>("hello world", HttpStatus.OK);
	}
}
