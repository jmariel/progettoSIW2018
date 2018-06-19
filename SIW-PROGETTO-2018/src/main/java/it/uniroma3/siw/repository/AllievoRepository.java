package it.uniroma3.siw.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo, Long>{
	public List<Allievo> findByNomeAndCognomeAndDataDiNascitaAndLuogoDiNascita (String nome, String cognome, Date dataDiNascita, String luogoDiNascita);
	public List<Allievo> findByCognome(String cognome);
	public List<Allievo> findByNome(String nome);
}