package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Centro {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String telefono;
	
	@Column(nullable=false)
	private int numMaxAllievi;
	
	@OneToMany(mappedBy = "centro", fetch = FetchType.EAGER)
	private List<Attività> listaAttività;

	public Centro() {}
	
	
	public Centro(Long id, String nome, String email, String telefono, int numMaxAllievi,
			List<Attività> listaAttività) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefono = telefono;
		this.numMaxAllievi = numMaxAllievi;
		this.listaAttività = listaAttività;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getNumMaxAllievi() {
		return numMaxAllievi;
	}

	public void setNumMaxAllievi(int numMaxAllievi) {
		this.numMaxAllievi = numMaxAllievi;
	}

	public List<Attività> getListaAttività() {
		return listaAttività;
	}

	public void setListaAttività(List<Attività> listaAttività) {
		this.listaAttività = listaAttività;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaAttività == null) ? 0 : listaAttività.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numMaxAllievi;
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Centro other = (Centro) obj;
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
		if (listaAttività == null) {
			if (other.listaAttività != null) {
				return false;
			}
		} else if (!listaAttività.equals(other.listaAttività)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (numMaxAllievi != other.numMaxAllievi) {
			return false;
		}
		if (telefono == null) {
			if (other.telefono != null) {
				return false;
			}
		} else if (!telefono.equals(other.telefono)) {
			return false;
		}
		return true;
	}
	
	
}
