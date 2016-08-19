package br.com.buzzpage.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_anuncio")
public class Anuncio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnuncio;

	private int numeroDiasVeiculacao;
	private Boolean flagLiberado;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataCriacao")
	private Date dataCriacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataInicial")
	private Date dataInicio;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataFinal")
	private Date dataFinal;

	

	
	// bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAnunciante")
	private Anunciante anunciante;

	@ManyToMany
	@JoinTable(name = "tb_paginas_anuncio", joinColumns = { @JoinColumn(name = "idAnuncio") }, inverseJoinColumns = {
			@JoinColumn(name = "idPagina") })
	private List<Pagina> paginas;

	@ManyToMany
	@JoinTable(name = "tb_regioes_anuncio", joinColumns = { @JoinColumn(name = "idAnuncio") }, inverseJoinColumns = {
			@JoinColumn(name = "idRegiao") })
	private List<Regiao> regioes;

	public Long getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public int getNumeroDiasVeiculacao() {
		return numeroDiasVeiculacao;
	}

	public void setNumeroDiasVeiculacao(int numeroDiasVeiculacao) {
		this.numeroDiasVeiculacao = numeroDiasVeiculacao;
	}

	public Boolean getFlagLiberado() {
		return flagLiberado;
	}

	public void setFlagLiberado(Boolean flagLiberado) {
		this.flagLiberado = flagLiberado;
	}
	
	
	public List<Pagina> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
	}

	public List<Regiao> getRegioes() {
		return regioes;
	}

	public void setRegioes(List<Regiao> regioes) {
		this.regioes = regioes;
	}

	public Anunciante getAnunciante() {
		return anunciante;
	}

	public void setAnunciante(Anunciante anunciante) {
		this.anunciante = anunciante;
	}
}