#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.vo;

import java.util.List;

public class BoletoVO {

	// gerarBoleto(,,,,,,,,,,,){

	private String nossoNumero; // id do pedido
	private String sacado; // ${symbol_dollar}nome
	private String cpfSacado; // ${symbol_dollar}cpf_cnpj
	private String numeroDocumento;
	private double valorBoleto; // valor total do pedido
	private String status;
	private String instrucoes;
	private String dataEmissao;
	private String dataValidade;
	private String mensagem;
	private String endereco; // ${symbol_dollar}endereco
	private String numero; // ${symbol_dollar}numero
	private String complemento;
	private String cidade; // ${symbol_dollar}cidade
	private String estado; // ${symbol_dollar}estado
	private String cep; // ${symbol_dollar}cep
	private Long tipoPedido;
	private String cpf_cnpj;

	// novos campos para o boleto do IUGU
	private String ddd; // ${symbol_dollar}ddd
	private String fone; // ${symbol_dollar}fone
	private String pais;// ${symbol_dollar}pais
	private String email; // ${symbol_dollar}email
	private List<ItemPedidoVO> itens; // ${symbol_dollar}itens

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public String getSacado() {
		return sacado;
	}

	public void setSacado(String sacado) {
		this.sacado = sacado;
	}

	public String getCpfSacado() {
		return cpfSacado;
	}

	public void setCpfSacado(String cpfSacado) {
		this.cpfSacado = cpfSacado;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public double getValorBoleto() {
		return valorBoleto;
	}

	public void setValorBoleto(double valorBoleto) {
		this.valorBoleto = valorBoleto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInstrucoes() {
		return instrucoes;
	}

	public void setInstrucoes(String instrucoes) {
		this.instrucoes = instrucoes;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

	public Long getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(Long tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ItemPedidoVO> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoVO> itens) {
		this.itens = itens;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

}
