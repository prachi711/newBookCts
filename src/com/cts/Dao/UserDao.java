package com.cts.Dao;

import com.cts.Entity.User;

public interface UserDao {

	
	// public UserDao getUserDAOImpl();
	
	public void registerUser(User user);
	public User loginUser(User user);
}
