#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tb_regiao database table.
 * 
 */
@Entity
@Table(name = "tb_regiao")
@NamedQuery(name = "Regiao.findAll", query = "SELECT r FROM Regiao r")
public class Regiao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRegiao;

	@Lob
	private String descricao;

	/*
	 * @ManyToMany(mappedBy = "regioes") private List<Anuncio> anuncios;
	 */

	public Regiao() {
	}

	public Long getIdRegiao() {
		return this.idRegiao;
	}

	public void setIdRegiao(Long idRegiao) {
		this.idRegiao = idRegiao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}