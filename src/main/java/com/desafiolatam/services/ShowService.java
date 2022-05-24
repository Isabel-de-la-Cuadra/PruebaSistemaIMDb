package com.desafiolatam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Show;
import com.desafiolatam.repositories.ShowRepository;

@Service
public class ShowService {

	@Autowired
	ShowRepository showRepository;
	
	public Show saveShow(Show show) {
		Show showCreated = showRepository.saveAndFlush(show);
		return showCreated;
	}
	
	public Show findByIdShow (Long id) {
		return showRepository.findById(id).get();
	}
	
	public Show findByShowTittle (String showTittle) {
		return showRepository.findByShowTittle(showTittle);
	}
	
	public void deleteByIdShow(Long id) {
		showRepository.deleteById(id);
	}
	
	public List<Show>findAll(){
		return showRepository.findAll();
	}

	public Page<Show> getPage(Pageable pageable) {
		return showRepository.findAll(pageable);
	}
}