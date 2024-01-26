package com.university.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.dao.IDao;
import com.university.entities.Filiere;
import com.university.repositories.FiliereRepository;

@Service
public class FiliereService implements IDao<Filiere> {
	@Autowired
	private FiliereRepository studentRepository;

	@Override
	public Filiere create(Filiere o) {
		return studentRepository.save(o);
	}

	@Override
	public List<Filiere> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Filiere update(Filiere o) {
		return studentRepository.save(o);
	}

	@Override
	public boolean delete(Filiere o) {
		try {
			studentRepository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Filiere findById(int id) {
		return studentRepository.findById(id).orElse(null);
	}
}
