package com.sol.mojo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sol.mojo.service.MojoService;

@RestController
@RequestMapping("/api")
public class MojoController {
	
	@Autowired
	private MojoService service;
	
	@GetMapping("/test")
	public String getHitCount() {
		return "The current hit count is " + service.hitServer();
	}

}
