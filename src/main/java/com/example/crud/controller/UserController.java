package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.User;
import com.example.crud.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("")
	public void addUser(@RequestBody User user) {
		userService.addOrUpdateUser(user);
	}
	
	@PutMapping("/update/{id}")
	public void updateUser(@RequestBody User user) {
		userService.addOrUpdateUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}
}
