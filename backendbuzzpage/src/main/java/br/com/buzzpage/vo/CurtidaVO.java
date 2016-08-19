package br.com.buzzpage.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class CurtidaVO {

	private Long idCurtida;
	private Long idConteudo;
	private Long idComentario;
	private Long idPessoa;
	private Long idUsuario;
	private String statusCurtida;
	private Date dataCurtida;

	public Long getIdCurtida() {
		return idCurtida;
	}

	public void setIdCurtida(Long idCurtida) {
		this.idCurtida = idCurtida;
	}

	public Long getIdConteudo() {
		return idConteudo;
	}

	public void setIdConteudo(Long idConteudo) {
		this.idConteudo = idConteudo;
	}

	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getStatusCurtida() {
		return statusCurtida;
	}

	public void setStatusCurtida(String statusCurtida) {
		this.statusCurtida = statusCurtida;
	}

	public Date getDataCurtida() {
		return dataCurtida;
	}

	public void setDataCurtida(Date dataCurtida) {
		this.dataCurtida = dataCurtida;
	}

}
