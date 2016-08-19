package br.com.buzzpage.vo;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class TextoVo {

	private Long idTexto;
	private Boolean statusLiberadoPublicar;
	private Short statusPublicacao;
	private Long idPatrocinio;
	private Long idPagina;
	private String palavra;
	private String sinonimos;
	private String titulo;
	private String resumo;
	private String texto;
	private Long idRedatorPrincipal;
	private String tituloPagina;
	private String slugPagina;
	private String nomeRedator;
	private String fotoRedator;
	private String resumoRedator;
	private String fotoDestaque;
	private String resumoTextoDestaque;
	private String slug;
	private String dataPost;
	private String usuario;
	private Boolean flagPublicado;

	public Long getIdTexto() {
		return idTexto;
	}

	public void setIdTexto(Long idTexto) {
		this.idTexto = idTexto;
	}

	public Boolean getStatusLiberadoPublicar() {
		return statusLiberadoPublicar;
	}

	public void setStatusLiberadoPublicar(Boolean statusLiberadoPublicar) {
		this.statusLiberadoPublicar = statusLiberadoPublicar;
	}

	public Short getStatusPublicacao() {
		return statusPublicacao;
	}

	public void setStatusPublicacao(Short statusPublicacao) {
		this.statusPublicacao = statusPublicacao;
	}

	public Long getIdPatrocinio() {
		return idPatrocinio;
	}

	public void setIdPatrocinio(Long idPatrocinio) {
		this.idPatrocinio = idPatrocinio;
	}

	public Long getIdPagina() {
		return idPagina;
	}

	public void setIdPagina(Long idPagina) {
		this.idPagina = idPagina;
	}

	public Long getIdRedatorPrincipal() {
		return idRedatorPrincipal;
	}

	public void setIdRedatorPrincipal(Long idRedatorPrincipal) {
		this.idRedatorPrincipal = idRedatorPrincipal;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavraChave) {
		this.palavra = palavraChave;
	}

	public String getSinonimos() {
		return sinonimos;
	}

	public void setSinonimos(String sinonimos) {
		this.sinonimos = sinonimos;
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTituloPagina() {
		return tituloPagina;
	}

	public void setTituloPagina(String tituloPagina) {
		this.tituloPagina = tituloPagina;
	}

	public String getFotoDestaque() {
		return fotoDestaque;
	}

	public void setFotoDestaque(String fotoDestaque) {
		this.fotoDestaque = fotoDestaque;
	}

	public String getResumoTextoDestaque() {
		return resumoTextoDestaque;
	}

	public void setResumoTextoDestaque(String resumoTextoDestaque) {
		this.resumoTextoDestaque = resumoTextoDestaque;
	}

	@Override
	public String toString() {
		return "TextoVo [idTexto=" + idTexto + ", statusLiberadoPublicar=" + statusLiberadoPublicar
				+ ", statusPublicacao=" + statusPublicacao + ", idPatrocinio=" + idPatrocinio + ", idPagina=" + idPagina
				+ ", palavra=" + palavra + ", sinonimos=" + sinonimos + ", titulo=" + titulo + ", resumo=" + resumo
				+ ", texto=" + texto + ", idRedatorPrincipal=" + idRedatorPrincipal + ", tituloPagina=" + tituloPagina
				+ "]";
	}

	public String getNomeRedator() {
		return nomeRedator;
	}

	public void setNomeRedator(String nomeRedator) {
		this.nomeRedator = nomeRedator;
	}

	public String getSlugPagina() {
		return slugPagina;
	}

	public void setSlugPagina(String slugPagina) {
		this.slugPagina = slugPagina;
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

	public String getFotoRedator() {
		return fotoRedator;
	}

	public void setFotoRedator(String fotoRedator) {
		this.fotoRedator = fotoRedator;
	}

	public String getResumoRedator() {
		return resumoRedator;
	}

	public void setResumoRedator(String resumoRedator) {
		this.resumoRedator = resumoRedator;
	}

	public Boolean getFlagPublicado() {
		return flagPublicado;
	}

	public void setFlagPublicado(Boolean flagPublicado) {
		this.flagPublicado = flagPublicado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
