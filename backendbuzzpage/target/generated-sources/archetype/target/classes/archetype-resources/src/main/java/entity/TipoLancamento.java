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
 * The persistent class for the tb_tipo_lancamento database table.
 * 
 */
@Entity
@Table(name = "tb_tipo_lancamento")
@NamedQuery(name = "TipoLancamento.findAll", query = "SELECT t FROM TipoLancamento t")
public class TipoLancamento implements Serializable {
	private static final long serialVersionUID = -6276697523496993604L;

	@Id
	private Long id;

	private String descricao;

	public TipoLancamento() {
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