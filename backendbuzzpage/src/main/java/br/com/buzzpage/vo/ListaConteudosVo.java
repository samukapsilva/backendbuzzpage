package br.com.buzzpage.vo;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class ListaConteudosVo {

	private Long idTexto;
	private String titulo;
	private String resumo;
	private String slug;
	private String dataPost;

	public Long getIdTexto() {
		return idTexto;
	}

	public void setIdTexto(Long idTexto) {
		this.idTexto = idTexto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDataPost() {
		return dataPost;
	}

	public void setDataPost(String dataPost) {
		this.dataPost = dataPost;
	}

}
