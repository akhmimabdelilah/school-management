package com.university.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.dao.IDao;
import com.university.entities.Role;
import com.university.repositories.RoleRepository;

@Service
public class RoleService implements IDao<Role> {
	@Autowired
	private RoleRepository studentRepository;

	@Override
	public Role create(Role o) {
		return studentRepository.save(o);
	}

	@Override
	public List<Role> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Role update(Role o) {
		return studentRepository.save(o);
	}

	@Override
	public boolean delete(Role o) {
		try {
			studentRepository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Role findById(int id) {
		return studentRepository.findById(id).orElse(null);
	}
}
