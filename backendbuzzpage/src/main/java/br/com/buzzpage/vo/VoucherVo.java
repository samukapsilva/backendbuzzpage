package br.com.buzzpage.vo;

  

public class VoucherVo {
	
	private Long idVoucher;

	private String codVoucher;
 
	private String dataGeracao;

	private Long idPessoa;

	private String ipUsuario;

	public Long getIdVoucher() {
		return idVoucher;
	}

	public void setIdVoucher(Long idVoucher) {
		this.idVoucher = idVoucher;
	}

	public String getCodVoucher() {
		return codVoucher;
	}

	public void setCodVoucher(String codVoucher) {
		this.codVoucher = codVoucher;
	}

	public String getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(String dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getIpUsuario() {
		return ipUsuario;
	}

	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}
	
	
	

}
