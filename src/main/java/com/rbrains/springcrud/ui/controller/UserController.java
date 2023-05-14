package com.rbrains.springcrud.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rbrains.springcrud.ui.model.request.UserDetailRequestModel;
import com.rbrains.springcrud.ui.model.response.UserRest;
import com.rbrains.springcrud.userservice.UserService;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

	@Autowired
	private UserService userService;
	
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
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) 
	{
		UserRest rest = userService.getUser(userId);
		if(rest!=null) {
			return new ResponseEntity<>(rest, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping(
			consumes = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
						},
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailRequestModel userDetailRequestModel) 
	{
		
		UserRest returnValue = userService.createUser(userDetailRequestModel);
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
	}
	
	@PutMapping(path = "/{userId}",
			consumes = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
						},
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			})
	public UserRest UpdateUser(@PathVariable String userId, @RequestBody UserDetailRequestModel model) {
		
		UserRest returnUpdatedUser = userService.UpdateUser(userId, model);
		return returnUpdatedUser;
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
