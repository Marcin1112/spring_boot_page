package com.zabadaj.marcin.zabadaj.marcin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zabadaj.marcin.zabadaj.marcin.model.User;

public interface UsersRepository extends JpaRepository<User, Integer>{
	Optional<User> findByName(String username);
}
