package br.com.buzzpage.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the tb_perfil database table.
 * 
 */
@Entity
@Table(name = "tb_perfil")
@NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPerfil;

	private String descricao;

	// bi-directional many-to-one association to PerfilUsuario
	@OneToMany(mappedBy = "tbPerfil")
	private List<PerfilUsuario> tbPerfilUsuarios;

	public Perfil() {
	}

	public Long getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<PerfilUsuario> getTbPerfilUsuarios() {
		return this.tbPerfilUsuarios;
	}

	public void setTbPerfilUsuarios(List<PerfilUsuario> tbPerfilUsuarios) {
		this.tbPerfilUsuarios = tbPerfilUsuarios;
	}

	public PerfilUsuario addTbPerfilUsuario(PerfilUsuario tbPerfilUsuario) {
		getTbPerfilUsuarios().add(tbPerfilUsuario);
		tbPerfilUsuario.setTbPerfil(this);

		return tbPerfilUsuario;
	}

	public PerfilUsuario removeTbPerfilUsuario(PerfilUsuario tbPerfilUsuario) {
		getTbPerfilUsuarios().remove(tbPerfilUsuario);
		tbPerfilUsuario.setTbPerfil(null);

		return tbPerfilUsuario;
	}

}