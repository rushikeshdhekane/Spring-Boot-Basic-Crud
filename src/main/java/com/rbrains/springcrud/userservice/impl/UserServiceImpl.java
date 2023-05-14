package com.rbrains.springcrud.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rbrains.springcrud.exception.UserServiceException;
import com.rbrains.springcrud.ui.model.request.UserDetailRequestModel;
import com.rbrains.springcrud.ui.model.response.UserRest;
import com.rbrains.springcrud.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{

	Map<String, UserRest> users;

	@Override
	public UserRest createUser(UserDetailRequestModel userDetailRequestModel) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetailRequestModel.getEmail());
		returnValue.setFirstName(userDetailRequestModel.getFirstName());
		returnValue.setLastName(userDetailRequestModel.getLastName());
		
		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		
		if(users == null)users= new HashMap<>(); 
		users.put(userId, returnValue);
		
		return returnValue;
	}

	@Override
	public UserRest getUser(String userId) {
		if(users.containsKey(userId)) {
			return users.get(userId);
		}
		else
		{
			throw new UserServiceException("User not found");
		}
	}

	@Override
	public UserRest UpdateUser(String userId, UserDetailRequestModel model) {
		UserRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirstName(model.getFirstName());
		storedUserDetails.setLastName(model.getLastName());
		
		users.put(userId, storedUserDetails);
		return storedUserDetails;
	}

	@Override
	public void deleteUser(String id) {
		users.remove(id);
	}

	
}
