package br.com.buzzpage.vo;

import java.util.Date;

import br.com.buzzpage.entity.Anuncio;
import br.com.buzzpage.entity.Pessoa;

public class PedidoAnuncioVO {

	private Long idPedidoAnuncio;

	private Double valorPedido;
	private Boolean flagPgtoPedido;
	private String tipoPessoa;
	private Long codIugu;
	private String codRede;
	private Date dataPedido;
	private Date dataPgto;
	private Pessoa pessoa;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

}
