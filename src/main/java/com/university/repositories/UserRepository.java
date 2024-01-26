package com.university.repositories;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findByRole(Role role);
}
