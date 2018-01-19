package com.zabadaj.marcin.zabadaj.marcin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zabadaj.marcin.zabadaj.marcin.model.Box;
import com.zabadaj.marcin.zabadaj.marcin.model.Reagent;
import com.zabadaj.marcin.zabadaj.marcin.model.User;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public interface BoxRepository extends JpaRepository<Box, Integer> {
	Optional<Box> findByName(String name);
}
