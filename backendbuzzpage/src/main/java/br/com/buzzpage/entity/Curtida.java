package br.com.buzzpage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_curtida")
@NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c")
public class Curtida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCurtida;

	// bi-directional many-to-one association to Texto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idConteudo")
	private Texto conteudo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idComentario")
	private Comentario comentario;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;

	// bi-directional many-to-one association to Usuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	private String statusCurtida;
	private Date dataCurtida;

	public Long getIdCurtida() {
		return idCurtida;
	}

	public void setIdCurtida(Long idCurtida) {
		this.idCurtida = idCurtida;
	}

	public Texto getConteudo() {
		return conteudo;
	}

	public void setConteudo(Texto conteudo) {
		this.conteudo = conteudo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getStatusCurtida() {
		return statusCurtida;
	}

	public void setStatusCurtida(String statusCurtida) {
		this.statusCurtida = statusCurtida;
	}

	public Date getDataCurtida() {
		return dataCurtida;
	}

	public void setDataCurtida(Date dataCurtida) {
		this.dataCurtida = dataCurtida;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
}