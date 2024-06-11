package com.mypack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/program")
public class ProgramController {

	@GetMapping
	String test() {
		System.out.println("test triggered");
		return "test triggered";
	}
}
