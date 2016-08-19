#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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

@Entity
@Table(name = "tb_pedido_anuncio")
@NamedQuery(name = "PedidoAnuncio.findAll", query = "SELECT a FROM PedidoAnuncio a")
public class PedidoAnuncio implements Serializable {

	private static final long serialVersionUID = 7157093228226945403L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedidoAnuncio;

	private Double valorPedido;
	private Boolean flagPgtoPedido;
	private String tipoPessoa;
	private Long codIugu;
	private String codRede;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataPedido")
	private Date dataPedido;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataPgto")
	private Date dataPgto;

	// bi-directional many-to-one association to Anunciante
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAnunciante")
	private Anunciante anunciante;

	// bi-directional many-to-one association to Anuncio
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAnuncio")
	private Anuncio anuncio;

	public Long getIdPedidoAnuncio() {
		return idPedidoAnuncio;
	}

	public void setIdPedidoAnuncio(Long idPedidoAnuncio) {
		this.idPedidoAnuncio = idPedidoAnuncio;
	}

	public Double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}

	public Boolean getFlagPgtoPedido() {
		return flagPgtoPedido;
	}

	public void setFlagPgtoPedido(Boolean flagPgtoPedido) {
		this.flagPgtoPedido = flagPgtoPedido;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Long getCodIugu() {
		return codIugu;
	}

	public void setCodIugu(Long codIugu) {
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

	public Anunciante getAnunciante() {
		return anunciante;
	}

	public void setAnunciante(Anunciante anunciante) {
		this.anunciante = anunciante;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

}