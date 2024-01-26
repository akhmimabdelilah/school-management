package com.university.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.dao.IDao;
import com.university.entities.Filiere;
import com.university.entities.Student;
import com.university.repositories.StudentRepository;

@Service
public class StudentService implements IDao<Student> {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student create(Student o) {
		return studentRepository.save(o);
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student update(Student o) {
		return studentRepository.save(o);
	}

	@Override
	public boolean delete(Student o) {
		try {
			studentRepository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Student findById(int id) {
		return studentRepository.findById(id).orElse(null);
	}

	public List<Student> findByFiliere(Filiere filiere) {
		return studentRepository.findByFiliere(filiere);
	}

}
