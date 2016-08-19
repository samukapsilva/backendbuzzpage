package br.com.buzzpage.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class ResultadoPesquisaPaginasVO {

	private TextoVo destaquePrincipal;
	private List<TextoVo> posts;
	private List<PaginaVo> paginas;
	private List<BuzzPagerVO> buzzpagers;
	private String tituloPagina;
	private String metaDescription;
	private String keyword;
	private String bannerTopo;
	private String linkBanner;

	public TextoVo getDestaquePrincipal() {
		return destaquePrincipal;
	}

	public void setDestaquePrincipal(TextoVo destaquePrincipal) {
		this.destaquePrincipal = destaquePrincipal;
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

	public List<BuzzPagerVO> getBuzzpagers() {
		return buzzpagers;
	}

	public void setBuzzpagers(List<BuzzPagerVO> buzzpagers) {
		this.buzzpagers = buzzpagers;
	}

	public List<TextoVo> getPosts() {
		return posts;
	}

	public void setPosts(List<TextoVo> posts) {
		this.posts = posts;
	}

	public List<PaginaVo> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<PaginaVo> paginas) {
		this.paginas = paginas;
	}

	public String getBannerTopo() {
		return bannerTopo;
	}

	public void setBannerTopo(String bannerTopo) {
		this.bannerTopo = bannerTopo;
	}

	public String getLinkBanner() {
		return linkBanner;
	}

	public void setLinkBanner(String linkBanner) {
		this.linkBanner = linkBanner;
	}

}
