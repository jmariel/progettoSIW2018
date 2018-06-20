package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Centro;

public interface CentroRepository extends CrudRepository<Centro, Long> {
	public List<Centro> findByNomeAndEmail(String nome, String email);
	public List<Centro> findByNome(String nome);
	public List<Centro> findByEmail (String email);
}
