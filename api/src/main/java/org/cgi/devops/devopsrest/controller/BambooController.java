package org.cgi.devops.devopsrest.controller;

import org.cgi.devops.devopsrest.model.BambooSpecs;
import org.cgi.devops.devopsrest.services.BambooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/bamboospecs")
@CrossOrigin(origins = "*")
public class BambooController {

	@Autowired
	private BambooService service;
	
	@PostMapping(value = "/config", consumes = { "application/json" })
	public ResponseEntity<String> postJson(@RequestBody BambooSpecs bambooSpecs) {	
		this.service.bambooTrigger(bambooSpecs);
		return new ResponseEntity<String>("Triggered Successfully", HttpStatus.OK);
	}
}
