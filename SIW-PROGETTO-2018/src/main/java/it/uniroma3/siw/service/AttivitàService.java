package it.uniroma3.siw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Attività;
import it.uniroma3.siw.repository.AttivitàRepository;

@Transactional
@Service
public class AttivitàService {
	
	@Autowired
	private AttivitàRepository repository;
	
	public Attività save(Attività attività) {
		return this.repository.save(attività);
	}
	
	public Attività findById(Long id) {
		Optional<Attività> attività = this.repository.findById(id);
		if (attività.isPresent())
			return attività.get();
		else
			return null;
	}
	
	public List<Attività> findAll(){
		return (List<Attività>) this.repository.findAll();
	}
	
	public boolean alreadyExist(Attività attività) {
		List<Attività> a = this.repository.findByNomeAndDataEora(attività.getNome(), attività.getDataEora());
		if(a.size() > 0)
			return true;
		else
			return false;
	}
	

}
