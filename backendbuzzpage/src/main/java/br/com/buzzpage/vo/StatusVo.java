package br.com.buzzpage.vo;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.buzzpage.exception.BuzzPageException;

@XmlRootElement
public class StatusVo {

	private String chave;
	private String valor;
	private String mensagem;
	private String nome;
	private Long statusConsultor;
	private Long idCadastrado;
	private Boolean status;
	private String foto;
	private BuzzPageException buzzPageException;

	public StatusVo(String chave, String valor, String mensagem) {
		this.chave = chave;
		this.valor = valor;
		this.mensagem = mensagem;
	}

	public StatusVo() {

	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getStatusConsultor() {
		return statusConsultor;
	}

	public void setStatusConsultor(Long statusConsultor) {
		this.statusConsultor = statusConsultor;
	}

	public Long getIdCadastrado() {
		return idCadastrado;
	}

	public void setIdCadastrado(Long idCadastrado) {
		this.idCadastrado = idCadastrado;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public BuzzPageException getBuzzPageException() {
		return buzzPageException;
	}

	public void setBuzzPageException(BuzzPageException buzzPageException) {
		this.buzzPageException = buzzPageException;
	}

	@Override
	public String toString() {
		return "StatusVO [chave=" + chave + ", valor=" + valor + ", mensagem=" + mensagem + ", nome=" + nome
				+ ", statusConsultor=" + statusConsultor + ", idCadastrado=" + idCadastrado + "]";
	}

}
