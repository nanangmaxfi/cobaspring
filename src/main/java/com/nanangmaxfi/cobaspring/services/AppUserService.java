package com.nanangmaxfi.cobaspring.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nanangmaxfi.cobaspring.models.entities.AppUser;
import com.nanangmaxfi.cobaspring.models.repos.AppUserRepo;

@Service
@Transactional
public class AppUserService implements UserDetailsService{
	
	@Autowired
	private AppUserRepo appUserRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return appUserRepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("User with email '$s' not found", email)));
	}

	public AppUser registerAppUser(AppUser user) {
		boolean userExists = appUserRepo.findByEmail(user.getEmail()).isPresent();
		if (userExists) {
			throw new RuntimeException(
					String.format("User with email '$s' not found", user.getEmail()));
		}
		
		String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		return appUserRepo.save(user);
	}
}
