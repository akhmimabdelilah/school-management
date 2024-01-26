package com.university.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.entities.Role;
import com.university.services.RoleService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping
	public Role createRole(@RequestBody Role role) {
		role.setId(0);
		return roleService.create(role);
	}

	@GetMapping
	public List<Role> findAllRole() {
		return roleService.findAll();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateRole(@PathVariable int id, @RequestBody Role newRole) {
		Role oldRole = roleService.findById(id);
		if (oldRole == null) {
			return new ResponseEntity<Object>("Role avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			oldRole.setId(id);
			return ResponseEntity.ok(roleService.update(newRole));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleRole(@PathVariable int id) {
		Role role = roleService.findById(id);
		if (role == null) {
			return new ResponseEntity<Object>("Role avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			roleService.delete(role);
			return ResponseEntity.ok("Role supprime");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Role role = roleService.findById(id);
		if (role == null) {
			return new ResponseEntity<Object>("Role avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {

			return ResponseEntity.ok(role);
		}
	}

}
