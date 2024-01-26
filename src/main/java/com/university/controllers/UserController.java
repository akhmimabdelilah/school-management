package com.university.controllers;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.entities.User;
import com.university.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public User createUser(@RequestBody User user) {
		user.setId(0);
		return userService.create(user);
	}

	@GetMapping
	public List<User> findAllUser() {
		return userService.findAll();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody User newUser) {
		User oldUser = userService.findById(id);
		if (oldUser == null) {
			return new ResponseEntity<Object>("User avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newUser.setId(id);
			return ResponseEntity.ok(userService.update(newUser));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<Object>("User avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			userService.delete(user);
			return ResponseEntity.ok("User supprimé");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<Object>("User avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(user);
		}
	}

	@GetMapping("/roles")
	public List<User> findByRole(@RequestBody Role role) {
		return userService.findByRole(role);
	}

}
