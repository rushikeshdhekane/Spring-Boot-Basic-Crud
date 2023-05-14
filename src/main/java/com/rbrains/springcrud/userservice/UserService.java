package com.rbrains.springcrud.userservice;

import com.rbrains.springcrud.ui.model.request.UserDetailRequestModel;
import com.rbrains.springcrud.ui.model.response.UserRest;

public interface UserService {

	UserRest createUser(UserDetailRequestModel userDetailRequestModel);
	
	UserRest getUser(String userId);
	
	UserRest UpdateUser(String userId,UserDetailRequestModel model);
	
	void deleteUser(String id);
}
