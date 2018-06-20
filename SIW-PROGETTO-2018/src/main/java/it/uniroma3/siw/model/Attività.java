package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Attività {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEora;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Allievo> listaAllievi;
	
	@ManyToOne
	private Centro centro;
	
	public Attività() {
	}

	public Attività(Long id, String nome, Date dataEora, List<Allievo> listaAllievi, Centro centro) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataEora = dataEora;
		this.listaAllievi = listaAllievi;
		this.centro = centro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataEora() {
		return dataEora;
	}

	public void setDataEora(Date dataEora) {
		this.dataEora = dataEora;
	}

	public List<Allievo> getListaAllievi() {
		return listaAllievi;
	}

	public void setListaAllievi(List<Allievo> listaAllievi) {
		this.listaAllievi = listaAllievi;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}
}
