package com.zabadaj.marcin.zabadaj.marcin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zabadaj.marcin.zabadaj.marcin.model.Reagent;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public interface ReagentsRepository extends JpaRepository<Reagent, Integer>{
	
}
