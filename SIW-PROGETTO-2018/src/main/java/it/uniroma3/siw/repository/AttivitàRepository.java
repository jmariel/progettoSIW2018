package it.uniroma3.siw.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Attività;

public interface AttivitàRepository extends CrudRepository<Attività, Long> {
	public List<Attività> findByNomeAndDataEora (String nome, Date dataEora);
	public List<Attività> findByNome(String nome);
	public List<Attività> findByDataEora(Date dataEora);

}
