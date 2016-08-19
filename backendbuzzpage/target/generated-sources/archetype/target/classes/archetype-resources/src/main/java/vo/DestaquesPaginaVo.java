#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class DestaquesPaginaVo {

	private TextoVo destaquePrincipal;
	private List<TextoVo> destaquesBlog;
	private String tituloPagina;
	private String metaDescription;
	private String keyword;

	public TextoVo getDestaquePrincipal() {
		return destaquePrincipal;
	}

	public void setDestaquePrincipal(TextoVo destaquePrincipal) {
		this.destaquePrincipal = destaquePrincipal;
	}

	public List<TextoVo> getDestaquesBlog() {
		return destaquesBlog;
	}

	public void setDestaquesBlog(List<TextoVo> destaquesBlog) {
		this.destaquesBlog = destaquesBlog;
	}

	public String getTituloPagina() {
		return tituloPagina;
	}

	public void setTituloPagina(String tituloPagina) {
		this.tituloPagina = tituloPagina;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
