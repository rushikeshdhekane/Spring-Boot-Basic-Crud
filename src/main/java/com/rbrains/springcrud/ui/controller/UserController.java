package com.rbrains.springcrud.ui.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rbrains.springcrud.ui.model.response.UserRest;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
	
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
						   @RequestParam(value = "limit",defaultValue = "50") int limit) 
	{
		return "get user get called with page = "+page+ " and limit = "+limit;
	}

	@GetMapping(path = "/{userId}", 
			    produces = {
			    		MediaType.APPLICATION_XML_VALUE,
			    		MediaType.APPLICATION_JSON_VALUE
			    		})
	public UserRest getUser(@PathVariable String userId) 
	{
		UserRest userRest = new UserRest();
		userRest.setEmail("r@gmail.com");
		userRest.setFirstName("rushi");
		userRest.setLastName("dhekane");
		userRest.setUserId(userId);
		
		return userRest;
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
