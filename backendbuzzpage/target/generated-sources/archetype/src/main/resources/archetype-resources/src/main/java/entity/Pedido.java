#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the tb_pedido database table.
 * 
 */
@Entity
@Table(name = "tb_pedido")
@NamedQuery(name = "Pedido.findAll", query = "SELECT t FROM Pedido t")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codIugu;
	private String codRede;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPedido;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPgto;

	private Boolean flagPgtoPedido;
	private byte idMeioPgto;
	private Integer qtdeCotas;
	private double valorPedido;

	// bi-directional many-to-one association to Anunciante
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAnunciante")
	private Anunciante anunciante;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodIugu() {
		return codIugu;
	}

	public void setCodIugu(String codIugu) {
		this.codIugu = codIugu;
	}

	public String getCodRede() {
		return codRede;
	}

	public void setCodRede(String codRede) {
		this.codRede = codRede;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataPgto() {
		return dataPgto;
	}

	public void setDataPgto(Date dataPgto) {
		this.dataPgto = dataPgto;
	}

	public Boolean getFlagPgtoPedido() {
		return flagPgtoPedido;
	}

	public void setFlagPgtoPedido(Boolean flagPgtoPedido) {
		this.flagPgtoPedido = flagPgtoPedido;
	}

	public byte getIdMeioPgto() {
		return idMeioPgto;
	}

	public void setIdMeioPgto(byte idMeioPgto) {
		this.idMeioPgto = idMeioPgto;
	}

	public Integer getQtdeCotas() {
		return qtdeCotas;
	}

	public void setQtdeCotas(Integer qtdeCotas) {
		this.qtdeCotas = qtdeCotas;
	}

	public double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}

	public Anunciante getAnunciante() {
		return anunciante;
	}

	public void setAnunciante(Anunciante anunciante) {
		this.anunciante = anunciante;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}