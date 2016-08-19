#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tb_categoria_pagina database table.
 * 
 */
@Entity
@Table(name = "tb_categoria_pagina")
@NamedQuery(name = "CategoriaPagina.findAll", query = "SELECT t FROM CategoriaPagina t")
public class CategoriaPagina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String descricao;

	private Long idTipoPagina;

	public CategoriaPagina() {
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

	public Long getIdTipoPagina() {
		return this.idTipoPagina;
	}

	public void setIdTipoPagina(Long idTipoPagina) {
		this.idTipoPagina = idTipoPagina;
	}

}