package com.zabadaj.marcin.zabadaj.marcin.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zabadaj.marcin.zabadaj.marcin.model.Box;
import com.zabadaj.marcin.zabadaj.marcin.model.Reagent;
import com.zabadaj.marcin.zabadaj.marcin.services.BoxRepositoryService;
import com.zabadaj.marcin.zabadaj.marcin.services.ReagentsRepositoryService;

@RequestMapping("/rest/")
@RestController
public class RestResources {

	@Autowired
	ReagentsRepositoryService reagentsRepositoryService;

	@Autowired
	BoxRepositoryService boxRepositoryService;

	@GetMapping("/all")
	public String hello() {
		return "Hello Youtube";
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
	@GetMapping("/secured/all")
	public String securedHello() {
		return "Secured Hello";
	}

	@GetMapping("/secured/alternate")
	public String alternate() {
		return "alternate";
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
	@GetMapping("/reagents")
	public List<Reagent> findAllReagents() {
		return reagentsRepositoryService.findAll();
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
	@GetMapping("/reagents/{id}")
	public List<Reagent> findOneReagent(@PathVariable String id) {
		List<Reagent> reagent = new ArrayList<Reagent>();
		reagent.add(reagentsRepositoryService.getOne(id));
		return reagent;
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
	@GetMapping("/box")
	public List<Box> findAllBoxes() {
		return boxRepositoryService.findAll();
	}
}
