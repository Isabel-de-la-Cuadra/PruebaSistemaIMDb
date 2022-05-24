package com.desafiolatam.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.UserIMDb;
import com.desafiolatam.repositories.RolRepository;
import com.desafiolatam.repositories.UserIMDbRepository;

@Service
public class UserIMDbService {

	@Autowired
	UserIMDbRepository userIMDbRepository;

	@Autowired
	RolRepository rolRepository;

	public boolean saveUserIMDb(UserIMDb userIMDb) {
		UserIMDb userIMDbReturn = userIMDbRepository.findByEmail(userIMDb.getEmail());
		if (userIMDbReturn == null) {
			// password encriptado
			String passHashed = BCrypt.hashpw(userIMDb.getPassword(), BCrypt.gensalt());
			// 1234 -> $223tgf4vt45tvt534dsvhdj
			userIMDb.setPassword(passHashed);

			// BUSCAR ROL a DB; ASIGNAR ROL; ROLE_ADMIN, ROLE_USER
			userIMDb.setRoles(rolRepository.findByName("ROLE_USER"));

			userIMDbRepository.save(userIMDb);
			return true;
		} else {
			return false;
		}
	}

	// Asignarle un nuevo rol a un usuario
	public boolean addRol(UserIMDb userIMDb) {
		userIMDbRepository.save(userIMDb);
		return true;
	}

	public boolean login(String email, String password) {
		// buscar si existe con ese email
		UserIMDb userIMDb = userIMDbRepository.findByEmail(email);

		if (userIMDb != null) {// si existe o no el correo
			if (BCrypt.checkpw(password, userIMDb.getPassword())) {
				return true;
			} else {
				return false;// pasword distintos
			}
		} else {
			return false;// no existe ese correo
		}
	}

	public UserIMDb findByEmail(String username) {
		UserIMDb userIMDb = userIMDbRepository.findByEmail(username);
		return userIMDb;
	}

	public List<UserIMDb> findAll() {
		return userIMDbRepository.findAll();
	}

}