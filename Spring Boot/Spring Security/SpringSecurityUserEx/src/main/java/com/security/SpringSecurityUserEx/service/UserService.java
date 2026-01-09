package com.security.SpringSecurityUserEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.SpringSecurityUserEx.entity.Users;
import com.security.SpringSecurityUserEx.repository.UserRespository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRespository userrepo;
	
	@Autowired
	private PasswordEncoder passwordencoder;
	
	
	public Users saveuser(Users user) {
		user.setPassword(passwordencoder.encode(user.getPassword()));
		return userrepo.save(user);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userrepo.findByName(username);
		if(user ==null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return User
				.withUsername(user.getName())
				.password(user.getPassword())
				.roles(user.getRole())
				.build();
		
	}
}
