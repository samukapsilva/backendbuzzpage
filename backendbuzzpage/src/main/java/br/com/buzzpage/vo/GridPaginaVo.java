package br.com.buzzpage.vo;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class GridPaginaVo implements DadosVo {

	private String titulo;
	private String categoria;
	private String tipo;
	private Long id;
	private int flagPublicado;
	private String slug;

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getFlagPublicado() {
		return flagPublicado;
	}

	public void setFlagPublicado(int flagPublicado) {
		this.flagPublicado = flagPublicado;
	}

}
