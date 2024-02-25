package com.codewitharjun.fullstackbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewitharjun.fullstackbackend.exception.UserNotFoundException;
import com.codewitharjun.fullstackbackend.model.User;
import com.codewitharjun.fullstackbackend.repository.UserRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/addUser")
	User saveUser(@RequestBody User newUser) {
		return userRepo.save(newUser);
	}
	
	@GetMapping("/allUsers")
	List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping("/user/{id}")
	User getUserById(@PathVariable long id) {
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User newUser, @PathVariable long id) {
		return userRepo.findById(id).map(user -> {
			user.setName(newUser.getName()); 
			user.setEmail(newUser.getEmail()); 
			user.setAddress(newUser.getAddress());
			return user;
			}).orElseThrow(() -> new UserNotFoundException(id));
	}


}
