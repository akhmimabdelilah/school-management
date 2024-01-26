package com.university.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.entities.Filiere;
import com.university.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public List<Student> findByFiliere(Filiere filiere);
}