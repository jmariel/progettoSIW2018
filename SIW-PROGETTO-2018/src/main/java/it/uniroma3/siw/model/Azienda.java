package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="azienda")
public class Azienda {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="azienda_id")
	private List<Centro> listaCentri;
	
	@OneToMany
	@JoinColumn(name="azienda_id")
	private List<Allievo> listaALlievi;
	
	
	@OneToMany
	@JoinColumn(name="azienda_id")
	private List<Responsabile> listaResponsabili;

	public Azienda() {
	}

	public Azienda(Long id, String nome, List<Centro> listaCentri, List<Allievo> listaALlievi,
			List<Responsabile> listaResponsabili) {
		super();
		this.id = id;
		this.nome = nome;
		this.listaCentri = listaCentri;
		this.listaALlievi = listaALlievi;
		this.listaResponsabili = listaResponsabili;
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

	public List<Centro> getListaCentri() {
		return listaCentri;
	}

	public void setListaCentri(List<Centro> listaCentri) {
		this.listaCentri = listaCentri;
	}

	public List<Allievo> getListaALlievi() {
		return listaALlievi;
	}

	public void setListaALlievi(List<Allievo> listaALlievi) {
		this.listaALlievi = listaALlievi;
	}

	public List<Responsabile> getListaResponsabili() {
		return listaResponsabili;
	}

	public void setListaResponsabili(List<Responsabile> listaResponsabili) {
		this.listaResponsabili = listaResponsabili;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaALlievi == null) ? 0 : listaALlievi.hashCode());
		result = prime * result + ((listaCentri == null) ? 0 : listaCentri.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Azienda other = (Azienda) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (listaALlievi == null) {
			if (other.listaALlievi != null) {
				return false;
			}
		} else if (!listaALlievi.equals(other.listaALlievi)) {
			return false;
		}
		if (listaCentri == null) {
			if (other.listaCentri != null) {
				return false;
			}
		} else if (!listaCentri.equals(other.listaCentri)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}
}
