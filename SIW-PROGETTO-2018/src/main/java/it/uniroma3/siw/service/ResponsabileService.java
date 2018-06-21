package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.repository.ResponsabileRepository;

@Transactional
@Service
public class ResponsabileService {
	
	@Autowired
	ResponsabileRepository repository;
	
	public Responsabile findByUsername(String email) {
		return repository.findByEmail(email); 	
	}
	
	public void save(Responsabile responsabile) {
		repository.save(responsabile);
	}

}
