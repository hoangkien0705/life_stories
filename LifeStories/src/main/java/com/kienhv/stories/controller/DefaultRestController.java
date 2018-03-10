package com.kienhv.stories.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultRestController {

	@RequestMapping("/public/greet")
	public String greet() {
		return "greet";
	}
}
