#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.vo;

import java.io.Serializable;

public class ItemPedidoVO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Long idProduto; // id da pagina onde anunciou, 
	private String nomeProduto; // nome da pagina
	private String resumoProduto; // nome da pagina
	private Integer qtdeProduto; // 1
	private Double precoUnitario; // pre�o que ta paganto, se um dia 7 dias 
	private Double valorTotal; //  qtde x valor unitario

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getResumoProduto() {
		return resumoProduto;
	}

	public void setResumoProduto(String resumoProduto) {
		this.resumoProduto = resumoProduto;
	}

	public Integer getQtdeProduto() {
		return qtdeProduto;
	}

	public void setQtdeProduto(Integer qtdeProduto) {
		this.qtdeProduto = qtdeProduto;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ItemPedidoVO(Long idProduto, String nomeProduto, String resumoProduto, Integer qtdeProduto,
			Double precoUnitario, Double valorTotal) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.resumoProduto = resumoProduto;
		this.qtdeProduto = qtdeProduto;
		this.precoUnitario = precoUnitario;
		this.valorTotal = valorTotal;
	}

	public ItemPedidoVO() {
		super();
	}

}
