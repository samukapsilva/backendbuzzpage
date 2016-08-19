package br.com.buzzpage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the tb_colaborador database table.
 * 
 */
@Embeddable
public class ColaboradorPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable = false, updatable = false)
	private int idPatrocinador;

	@Column(insertable = false, updatable = false)
	private int idPessoa;

	public ColaboradorPK() {
	}

	public int getIdPatrocinador() {
		return this.idPatrocinador;
	}

	public void setIdPatrocinador(int idPatrocinador) {
		this.idPatrocinador = idPatrocinador;
	}

	public int getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ColaboradorPK)) {
			return false;
		}
		ColaboradorPK castOther = (ColaboradorPK) other;
		return (this.idPatrocinador == castOther.idPatrocinador) && (this.idPessoa == castOther.idPessoa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPatrocinador;
		hash = hash * prime + this.idPessoa;

		return hash;
	}
}