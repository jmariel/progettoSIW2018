package it.uniroma3.siw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.repository.AllievoRepository;

@Transactional
@Service
public class AllievoService {
	
	@Autowired
	private AllievoRepository repository;
	
	public Allievo save (Allievo allievo) {
		return this.repository.save(allievo);
	}
	
	public List<Allievo> findAll(){
		return (List<Allievo>) this.repository.findAll();
	}
	
	public Allievo findById(Long id) {
		Optional<Allievo> allievo = this.repository.findById(id);
		if(allievo.isPresent())
			return allievo.get();
		else
			return null;
	}
	
	public boolean alreadyExist(Allievo allievo) {
		List<Allievo> allievi = this.repository.findByNomeAndCognomeAndDataDiNascitaAndLuogoDiNascita(allievo.getNome(), allievo.getCognome(), allievo.getDataDiNascita(), allievo.getLuogoDiNascita());
		if(allievi.size() > 0)
			return true;
		else
			return false;
	}

}
