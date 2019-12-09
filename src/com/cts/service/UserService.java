package com.cts.service;
import com.cts.Entity.User;


public interface UserService {

	
	public void registerUser(User user);

	public User loginUser(User user);
}
