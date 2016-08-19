#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;

import javax.persistence.Column;
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The persistent class for the tb_pagina database table.
 * 
 */
@Entity
@Table(name = "tb_pagina")
@NamedQuery(name = "Pagina.findAll", query = "SELECT p FROM Pagina p")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, include = "all")
public class Pagina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPagina;

	private String palavraChave;

	private String resumo;

	@Lob
	private String texto;

	private String titulo;

	@Column(unique = true)
	private String slug;

	private String cep;
	private String endereco;
	private String cidade;
	private String estado;
	private String fone;
	private String site;
	private Long idTipoPagina;
	private Long idCategoriaPagina;

	private Boolean flagPublicado;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;

	/*
	 * @ManyToMany(mappedBy = "paginas") private List<Anuncio> anuncios;
	 */

	public Pagina() {
	}

	public Long getIdPagina() {
		return this.idPagina;
	}

	public void setIdPagina(Long idPagina) {
		this.idPagina = idPagina;
	}

	public String getPalavraChave() {
		return this.palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}

	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Long getIdTipoPagina() {
		return idTipoPagina;
	}

	public void setIdTipoPagina(Long idTipoPagina) {
		this.idTipoPagina = idTipoPagina;
	}

	public Long getIdCategoriaPagina() {
		return idCategoriaPagina;
	}

	public void setIdCategoriaPagina(Long idCategoriaPagina) {
		this.idCategoriaPagina = idCategoriaPagina;
	}

	public Boolean getFlagPublicado() {
		return flagPublicado;
	}

	public void setFlagPublicado(Boolean flagPublicado) {
		this.flagPublicado = flagPublicado;
	}

	// public List<Anuncio> getAnuncios() {
	// return anuncios;
	// }
	//
	// public void setAnuncios(List<Anuncio> anuncios) {
	// this.anuncios = anuncios;
	// }

	@Override
	public String toString() {
		return "Pagina [titulo=" + titulo + ", slug=" + slug + "]";
	}

}