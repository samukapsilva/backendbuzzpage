package br.com.buzzpage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the tb_perfil_usuario database table.
 * 
 */
@Embeddable
public class PerfilUsuarioPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable = false, updatable = false)
	private Long idPerfil;

	@Column(insertable = false, updatable = false)
	private Long idPessoa;

	public PerfilUsuarioPK() {
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PerfilUsuarioPK)) {
			return false;
		}
		PerfilUsuarioPK castOther = (PerfilUsuarioPK) other;
		return (this.idPerfil == castOther.idPerfil) && (this.idPessoa == castOther.idPessoa);
	}

}