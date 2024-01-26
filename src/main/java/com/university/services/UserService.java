package com.university.services;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.dao.IDao;
import com.university.entities.User;
import com.university.repositories.UserRepository;

@Service
public class UserService implements IDao<User> {

	@Autowired
	private UserRepository userRepository;

//	T create(T o);
//	boolean delete(T o);
//	T update(T o);
//	T findById(int id);
//	List<T> findAll();

	@Override
	public User create(User o) {
		return userRepository.save(o);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User update(User o) {
		return userRepository.save(o);
	}

	@Override
	public boolean delete(User o) {
		try {
			userRepository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User findById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public List<User> findByRole(Role role) {
		return userRepository.findByRole(role);
	}

}
