#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tb_perfil_usuario database table.
 * 
 */
@Entity
@Table(name = "tb_perfil_usuario")
@NamedQuery(name = "PerfilUsuario.findAll", query = "SELECT p FROM PerfilUsuario p")
public class PerfilUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PerfilUsuarioPK id;

	// bi-directional many-to-one association to Perfil
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPerfil", insertable = false, updatable = false)
	private Perfil tbPerfil;

	public PerfilUsuario() {
	}

	public PerfilUsuarioPK getId() {
		return this.id;
	}

	public void setId(PerfilUsuarioPK id) {
		this.id = id;
	}

	public Perfil getTbPerfil() {
		return this.tbPerfil;
	}

	public void setTbPerfil(Perfil tbPerfil) {
		this.tbPerfil = tbPerfil;
	}

}