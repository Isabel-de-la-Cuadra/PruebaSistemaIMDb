package com.desafiolatam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.UserIMDb;

@Repository
public interface UserIMDbRepository extends JpaRepository<UserIMDb, Long> {

	UserIMDb findByEmail(String email);
	
}
