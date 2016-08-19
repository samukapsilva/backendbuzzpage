package br.com.buzzpage.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class PedidoVo {

	private Long idPedido;
	private String codIugu;
	private String codRede;
	private String dataPedido;
	private Date dataPgto;
	private Boolean flagPgtoPedido;
	private Byte idMeioPgto;
	private Integer qtdeCotas;
	private double valorPedido;
	private Long idPessoa;

	private String nomePessoa;
	private String cpf;
	private String endereco;
	private String cidade;
	private String estado;
	private String cep;

	// print
	// "$email,$itens,$cpf_cnpj,$nome,$ddd,$fone,$endereco,$numero,$cidade,$estado,$pais,$cep";

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
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

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
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

	public Byte getIdMeioPgto() {
		return idMeioPgto;
	}

	public void setIdMeioPgto(Byte idMeioPgto) {
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

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
