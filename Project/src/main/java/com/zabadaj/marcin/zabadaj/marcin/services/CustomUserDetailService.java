package com.zabadaj.marcin.zabadaj.marcin.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zabadaj.marcin.zabadaj.marcin.model.CustomUserDetails;
import com.zabadaj.marcin.zabadaj.marcin.model.User;
import com.zabadaj.marcin.zabadaj.marcin.repository.UsersRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUsers = usersRepository.findByName(username);
		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("NIe znaleziono użytkownika"));
		return optionalUsers.map(CustomUserDetails::new).get();
	}

}
