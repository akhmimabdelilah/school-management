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

import com.university.entities.Filiere;
import com.university.services.FiliereService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {
	@Autowired
	private FiliereService filiereService;

	@PostMapping
	public Filiere createFiliere(@RequestBody Filiere filiere) {
		filiere.setId(0);
		return filiereService.create(filiere);
	}

	@GetMapping
	public List<Filiere> findAllFiliere() {
		return filiereService.findAll();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateFiliere(@PathVariable int id, @RequestBody Filiere newFiliere) {
		Filiere oldFiliere = filiereService.findById(id);
		if (oldFiliere == null) {
			return new ResponseEntity<Object>("Filiere avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			oldFiliere.setId(id);
			return ResponseEntity.ok(filiereService.update(newFiliere));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleFiliere(@PathVariable int id) {
		Filiere filiere = filiereService.findById(id);
		if (filiere == null) {
			return new ResponseEntity<Object>("Filiere avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			filiereService.delete(filiere);
			return ResponseEntity.ok("Filiere supprime");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Filiere filiere = filiereService.findById(id);
		if (filiere == null) {
			return new ResponseEntity<Object>("Filiere avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {

			return ResponseEntity.ok(filiere);
		}
	}

}
