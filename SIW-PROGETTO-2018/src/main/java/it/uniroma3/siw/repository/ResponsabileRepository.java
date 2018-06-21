package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Responsabile;

public interface ResponsabileRepository extends CrudRepository <Responsabile, Long> {
	public Responsabile findByEmail(String email);

}
