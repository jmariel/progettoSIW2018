package it.uniroma3.siw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.repository.CentroRepository;

@Transactional
@Service
public class CentroService {
	
	@Autowired
	private CentroRepository repository;
	
	public Centro save(Centro centro) {
		return this.repository.save(centro);
	}
	
	public Centro findById(Long id) {
		Optional<Centro> centro = this.repository.findById(id);
		if(centro.isPresent())
			return centro.get();
		else
			return null;
	}
	
	public List<Centro> findAll(){
		return (List<Centro>) this.repository.findAll();
	}
	
	public boolean alreadyExist(Centro centro) {
		List <Centro> a = this.repository.findByNomeAndEmail(centro.getNome(), centro.getEmail());
		if(a.size() > 0)
			return true;
		else
			return false;
	}
}

