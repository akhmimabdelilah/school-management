package com.university.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String login;
	protected String password;
	@ManyToMany
	protected List<Role> role;

	public User() {
		super();
	}

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public User(int id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public User(int id, String login, String password, List<Role> role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return role;
	}

	public void setRoles(List<Role> role) {
		this.role = role;
	}

}
