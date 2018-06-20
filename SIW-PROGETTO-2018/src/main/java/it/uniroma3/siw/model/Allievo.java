package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Allievo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cognome;
	
	@Column(nullable=false)
	private String email;
	
	private int telefono;
	
	private String luogoDiNascita;
	
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;
	
	@ManyToMany
	private List<Attività> listaAttivitàAllievo;
	
	public Allievo() {
	}

	public Allievo(Long id, String nome, String cognome, String email, int telefono, String luogoDiNascita,
			Date dataDiNascita, List<Attività> listaAttivitàAllievo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.luogoDiNascita = luogoDiNascita;
		this.dataDiNascita = dataDiNascita;
		this.listaAttivitàAllievo = listaAttivitàAllievo;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public List<Attività> getListaAttivitàAllievo() {
		return listaAttivitàAllievo;
	}

	public void setListaAttivitàAllievo(List<Attività> listaAttivitàAllievo) {
		this.listaAttivitàAllievo = listaAttivitàAllievo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataDiNascita == null) ? 0 : dataDiNascita.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaAttivitàAllievo == null) ? 0 : listaAttivitàAllievo.hashCode());
		result = prime * result + ((luogoDiNascita == null) ? 0 : luogoDiNascita.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + telefono;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Allievo other = (Allievo) obj;
		if (cognome == null) {
			if (other.cognome != null) {
				return false;
			}
		} else if (!cognome.equals(other.cognome)) {
			return false;
		}
		if (dataDiNascita == null) {
			if (other.dataDiNascita != null) {
				return false;
			}
		} else if (!dataDiNascita.equals(other.dataDiNascita)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (listaAttivitàAllievo == null) {
			if (other.listaAttivitàAllievo != null) {
				return false;
			}
		} else if (!listaAttivitàAllievo.equals(other.listaAttivitàAllievo)) {
			return false;
		}
		if (luogoDiNascita == null) {
			if (other.luogoDiNascita != null) {
				return false;
			}
		} else if (!luogoDiNascita.equals(other.luogoDiNascita)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (telefono != other.telefono) {
			return false;
		}
		return true;
	}
	
	
}
