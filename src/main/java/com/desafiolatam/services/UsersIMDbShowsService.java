package com.desafiolatam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.UsersIMDbShows;
import com.desafiolatam.repositories.UsersIMDbShowsRepository;

@Service
public class UsersIMDbShowsService {

	@Autowired
	UsersIMDbShowsRepository usersIMDbShowsRepository;
	
	public void saveUsersIMDbShows(UsersIMDbShows usersIMDbShows) {
		usersIMDbShowsRepository.saveAndFlush(usersIMDbShows);
	}
	
	public UsersIMDbShows findByIdUsersIMDbShows (Long id) {
		return usersIMDbShowsRepository.findById(id).get();
	}
	
	public List<UsersIMDbShows>findAll(){
		return usersIMDbShowsRepository.findAll();
	}
	
}
