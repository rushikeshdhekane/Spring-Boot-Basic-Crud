package com.rbrains.springcrud.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

	@GetMapping
	public String getUsers() {
		return "get user get called";
	}
	
	@PostMapping
	public String createUser() {
		return "create user get called";
	}
	
	@PutMapping
	public String UpdateUser() {
		return "update user get called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user get called";
	}
	
	
}
