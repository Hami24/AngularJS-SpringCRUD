package com.example.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.dao.UserDao;
import com.example.crud.model.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Transactional
	public List <User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	@Transactional
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
	
	@Transactional
	public void addOrUpdateUser(User user) {
		userDao.addOrUpdateUser(user);
	}
}
