package com.desafiolatam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>, PagingAndSortingRepository<Show, Long> {
	
	Show findByShowTittle(String showTittle);
}
