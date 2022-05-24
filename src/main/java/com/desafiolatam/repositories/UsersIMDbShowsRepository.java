package com.desafiolatam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.UsersIMDbShows;

@Repository
public interface UsersIMDbShowsRepository extends JpaRepository<UsersIMDbShows, Long>{

}
