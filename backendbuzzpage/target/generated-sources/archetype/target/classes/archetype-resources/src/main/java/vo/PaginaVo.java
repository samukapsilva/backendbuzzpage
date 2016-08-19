#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.vo;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class PaginaVo {

	private Long idPagina;
	private String palavraChave;
	private String resumo;
	private String titulo;
	private String texto;
	private String slug;
	private Long idPessoa;
	private String cep;
	private String endereco;
	private String cidade;
	private String estado;
	private String fone;
	private String site;
	private String palavra;
	private Long idTipoPagina;
	private Long idCategoriaPagina;
	private String categoria;
	private String tipo;
	private Boolean flagPublicado;

	/*
	 * 
	 * 
	 * pagina.titulo selectedCateg pagina.cep pagina.endereco pagina.cidade
	 * pagina.estado pagina.fone pagina.site pagina.palavra pagina.resumo
	 * ${symbol_dollar}scope.idTipoPagina
	 * 
	 * 
	 */

	public Boolean getFlagPublicado() {
		return flagPublicado;
	}

	public void setFlagPublicado(Boolean flagPublicado) {
		this.flagPublicado = flagPublicado;
	}

	public Long getIdPagina() {
		return idPagina;
	}

	public void setIdPagina(Long idPagina) {
		this.idPagina = idPagina;
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public Long getIdTipoPagina() {
		return idTipoPagina;
	}

	public void setIdTipoPagina(Long idTipoPagina) {
		this.idTipoPagina = idTipoPagina;
	}

	public Long getIdCategoriaPagina() {
		return idCategoriaPagina;
	}

	public void setIdCategoriaPagina(Long idCategoriaPagina) {
		this.idCategoriaPagina = idCategoriaPagina;
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

}
