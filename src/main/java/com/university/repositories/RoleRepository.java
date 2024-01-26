package com.university.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
