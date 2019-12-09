package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cts.Dao.UserDao;
import com.cts.Entity.User;
@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public void registerUser(User user) {
		
		 userDao.registerUser(user);
	}

	@Override
	public User loginUser(User user) {
		
		return userDao.loginUser(user);
	}

}
