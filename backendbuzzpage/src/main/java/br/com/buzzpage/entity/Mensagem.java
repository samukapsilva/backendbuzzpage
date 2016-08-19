package br.com.buzzpage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the tb_feedback database table.
 * 
 */
@Entity
@Table(name = "tb_mensagem")
@NamedQuery(name = "Mensagem.findAll", query = "SELECT f FROM Mensagem f")
public class Mensagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataMensagem;

	private byte statusMensagem;

	@Lob
	private String texto;

	private String titulo;

	// bi-directional many-to-one association to Texto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idConteudo")
	private Texto textoVinculado;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRemetente")
	private Pessoa remetente;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDestinatario")
	private Pessoa destinatario;

	public Mensagem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataMensagem() {
		return dataMensagem;
	}

	public void setDataMensagem(Date dataMensagem) {
		this.dataMensagem = dataMensagem;
	}

	public byte getStatusMensagem() {
		return statusMensagem;
	}

	public void setStatusMensagem(byte statusMensagem) {
		this.statusMensagem = statusMensagem;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Pessoa getRemetente() {
		return remetente;
	}

	public void setRemetente(Pessoa remetente) {
		this.remetente = remetente;
	}

	public Pessoa getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Pessoa destinatario) {
		this.destinatario = destinatario;
	}

	public Texto getTextoVinculado() {
		return textoVinculado;
	}

	public void setTextoVinculado(Texto textoVinculado) {
		this.textoVinculado = textoVinculado;
	}

}