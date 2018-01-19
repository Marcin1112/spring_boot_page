package com.zabadaj.marcin.zabadaj.marcin.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.zabadaj.marcin.zabadaj.marcin.model.Reagent;
import com.zabadaj.marcin.zabadaj.marcin.repository.ReagentsRepository;

@Service
@Transactional
public class ReagentsRepositoryService {

	@Autowired
	private ReagentsRepository reagentsRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Reagent> findAll() {
		List<Reagent> list = reagentsRepository.findAll();
		return list;
	}

	public Reagent getOne(String id) {
		Reagent reagent = reagentsRepository.getOne(Integer.parseInt(id));
		return reagent;
	}

	public void updateReagent(Reagent reagent) {
		reagentsRepository.saveAndFlush(reagent);
	}

	public void save(Reagent reagent) {
		entityManager.persist(reagent);
	}

	public void deleteReagent(Reagent reagent) {
		entityManager.remove(reagent);
	}
}
