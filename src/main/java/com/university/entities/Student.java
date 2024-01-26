package com.university.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Student extends User {

	private String firstName;
	private String lastName;
	private String telephone;
	@ManyToOne
	private Filiere filiere;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String telephone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
	}
	

	public Student(String firstName, String lastName, String telephone, Filiere filiere) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.filiere = filiere;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Filiere getFilieres() {
		return filiere;
	}

	public void setFilieres(Filiere filiere) {
		this.filiere = filiere;
	}

}
