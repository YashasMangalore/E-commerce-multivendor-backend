package com.ecom.service;

import com.ecom.exception.UserException;
import com.ecom.model.User;

public interface UserService {

	public User findUserProfileByJwt(String jwt) throws UserException;
	
	public User findUserByEmail(String email) throws UserException;


}
