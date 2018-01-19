package com.zabadaj.marcin.zabadaj.marcin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabadaj.marcin.zabadaj.marcin.model.Box;
import com.zabadaj.marcin.zabadaj.marcin.repository.BoxRepository;

@Service
public class BoxRepositoryService {

	@Autowired
	BoxRepository boxRepository;

	public List<Box> findAll() {
		List<Box> list = boxRepository.findAll();
		return list;
	}

	public Box findByName(String name) {
		int comm = name.indexOf(",");
		if (comm != -1) {
			name = name.substring(++comm, name.length());
			return boxRepository.findByName(name).get();
		}
		Optional<Box> box = boxRepository.findByName(name);
		if (box.isPresent()) {
			return boxRepository.findByName(name).get();
		} else {
			return boxRepository.findAll().get(0);
		}
	}
}
