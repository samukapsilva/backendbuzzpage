package br.com.buzzpage.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class ProfileVo {

	private Long idPessoa;
	private String nome;
	private Long idSexo;

	private Integer diaAniversario;
	private Integer anoAniversario;
	private Integer mesAniversario;

	private String sobreMim;
	private String facebook;
	private String linkedin;
	private String twitter;
	private String blogger;
	private String youtube;
	private String googleMais;
	private String site;

	private Boolean aceiteTermos;
	private Boolean publicarRedes;
	private Boolean publicarSite;
	private Boolean publicarAutoria;

	private String fotoPerfil;
	private String ipAceite;
	private String slug;

	private List<ListaConteudosVo> conteudos;

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(Long idSexo) {
		this.idSexo = idSexo;
	}

	public Integer getDiaAniversario() {
		return diaAniversario;
	}

	public void setDiaAniversario(Integer diaAniversario) {
		this.diaAniversario = diaAniversario;
	}

	public Integer getAnoAniversario() {
		return anoAniversario;
	}

	public void setAnoAniversario(Integer anoAniversario) {
		this.anoAniversario = anoAniversario;
	}

	public Integer getMesAniversario() {
		return mesAniversario;
	}

	public void setMesAniversario(Integer mesAniversario) {
		this.mesAniversario = mesAniversario;
	}

	public String getSobreMim() {
		return sobreMim;
	}

	public void setSobreMim(String sobreMim) {
		this.sobreMim = sobreMim;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getBlogger() {
		return blogger;
	}

	public void setBlogger(String blogger) {
		this.blogger = blogger;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getGoogleMais() {
		return googleMais;
	}

	public void setGoogleMais(String googleMais) {
		this.googleMais = googleMais;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Boolean getAceiteTermos() {
		return aceiteTermos;
	}

	public void setAceiteTermos(Boolean aceiteTermos) {
		this.aceiteTermos = aceiteTermos;
	}

	public Boolean getPublicarRedes() {
		return publicarRedes;
	}

	public void setPublicarRedes(Boolean publicarRedes) {
		this.publicarRedes = publicarRedes;
	}

	public Boolean getPublicarSite() {
		return publicarSite;
	}

	public void setPublicarSite(Boolean publicarSite) {
		this.publicarSite = publicarSite;
	}

	public Boolean getPublicarAutoria() {
		return publicarAutoria;
	}

	public void setPublicarAutoria(Boolean publicarAutoria) {
		this.publicarAutoria = publicarAutoria;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getIpAceite() {
		return ipAceite;
	}

	public void setIpAceite(String ipAceite) {
		this.ipAceite = ipAceite;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public List<ListaConteudosVo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<ListaConteudosVo> conteudos) {
		this.conteudos = conteudos;
	}

}
