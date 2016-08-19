package br.com.buzzpage.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tb_tipo_pagina database table.
 * 
 */
@Entity
@Table(name = "tb_tipo_pagina")
@NamedQuery(name = "TipoPagina.findAll", query = "SELECT t FROM TipoPagina t")
public class TipoPagina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String descricao;

	public TipoPagina() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}