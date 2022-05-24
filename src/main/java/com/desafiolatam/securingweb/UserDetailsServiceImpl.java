package com.desafiolatam.securingweb;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Rol;
import com.desafiolatam.models.UserIMDb;
import com.desafiolatam.repositories.UserIMDbRepository;

@Service
public class UserDetailsServiceImpl implements  UserDetailsService{

	@Autowired
	UserIMDbRepository userIMDbRepository;
//1
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserIMDb userIMDb = userIMDbRepository.findByEmail(username);
		UserDetails userDetails = new User(userIMDb.getEmail(),userIMDb.getPassword(),getAuthorities(userIMDb)); 
		return userDetails;
	}
//2
    private List<GrantedAuthority> getAuthorities(UserIMDb userIMDb){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Rol rol : userIMDb.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.getName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}