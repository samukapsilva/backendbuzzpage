#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.vo;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class ComentarioVO {

	private Long idComentario;
	private Long idComentarioPai;
	private Long idConteudo;
	private Long idPessoa;
	private Long idUsuario;
	private String statusComentario;
	private String textoComentario;
	private String dataComentario;
	private String fotoDestaque;

	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public Long getIdComentarioPai() {
		return idComentarioPai;
	}

	public void setIdComentarioPai(Long idComentarioPai) {
		this.idComentarioPai = idComentarioPai;
	}

	public Long getIdConteudo() {
		return idConteudo;
	}

	public void setIdConteudo(Long idConteudo) {
		this.idConteudo = idConteudo;
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

	public String getStatusComentario() {
		return statusComentario;
	}

	public void setStatusComentario(String statusComentario) {
		this.statusComentario = statusComentario;
	}

	public String getTextoComentario() {
		return textoComentario;
	}

	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}

	public String getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(String dataComentario) {
		this.dataComentario = dataComentario;
	}

	public String getFotoDestaque() {
		return fotoDestaque;
	}

	public void setFotoDestaque(String fotoDestaque) {
		this.fotoDestaque = fotoDestaque;
	}
}
