package it.uniroma3.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Responsabile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cognome;
	
	@Column(nullable=false)
	private String ruolo;
	
	@Column(nullable=false)
	private String email;	
	
	private String password;
	
	@OneToOne
	private Azienda azienda;
	
	@OneToOne
	private Centro centro;
	
	
	public Responsabile() {
	}

	public Responsabile(Long id, String nome, String cognome, String ruolo, String email, String password,
			Azienda azienda, Centro centro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
		this.email = email;
		this.password = password;
		this.azienda = azienda;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((azienda == null) ? 0 : azienda.hashCode());
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((ruolo == null) ? 0 : ruolo.hashCode());
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
		Responsabile other = (Responsabile) obj;
		if (azienda == null) {
			if (other.azienda != null) {
				return false;
			}
		} else if (!azienda.equals(other.azienda)) {
			return false;
		}
		if (centro == null) {
			if (other.centro != null) {
				return false;
			}
		} else if (!centro.equals(other.centro)) {
			return false;
		}
		if (cognome == null) {
			if (other.cognome != null) {
				return false;
			}
		} else if (!cognome.equals(other.cognome)) {
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
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (ruolo == null) {
			if (other.ruolo != null) {
				return false;
			}
		} else if (!ruolo.equals(other.ruolo)) {
			return false;
		}
		return true;
	}	
}

