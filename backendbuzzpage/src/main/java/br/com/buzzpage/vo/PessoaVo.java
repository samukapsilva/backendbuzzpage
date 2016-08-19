package br.com.buzzpage.vo;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class PessoaVo {

	private Long idPessoa;
	private String nome;
	private Long idSexo;
	private Integer tipoDocumento;
	private String numeroDocumento;
	private String numeroRG;
	private String numero;
	private String endereco;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private String cep;
	private String email;
	private String dddFoneCelular;
	private String dddFoneFixo;
	private String foneCelular;
	private String foneFixo;
	private String loginDivulgador;
	private String senha;
	private String usuario;
	private String numeroBanco;
	private String agenciaBanco;
	private String contaBanco;
	private String tipoConta;
	private String operacaoBanco;
	private Integer diaAniversario;
	private Integer anoAniversario;
	private Integer mesAniversario;
	private Integer isAdministrador;
	private Integer isEditor;
	private String sobreMim;
	private String facebook;
	private String linkedin;
	private String twitter;
	private String blogger;
	private String youtube;
	private String googleMais;
	private String site;
	private String paypal;
	private String pagseguro;

	private Boolean aceiteTermos;
	private Boolean publicarRedes;
	private Boolean publicarSite;
	private Boolean publicarAutoria;

	private String confirmacaoSenha;
	private String senhaAtual;
	private String fotoPerfil;
	private String ipAceite;
	private String slug;

	private String emailIndicador;

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

	public Integer getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNumeroRG() {
		return numeroRG;
	}

	public void setNumeroRG(String numeroRG) {
		this.numeroRG = numeroRG;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDddFoneCelular() {
		return dddFoneCelular;
	}

	public void setDddFoneCelular(String dddFoneCelular) {
		this.dddFoneCelular = dddFoneCelular;
	}

	public String getDddFoneFixo() {
		return dddFoneFixo;
	}

	public void setDddFoneFixo(String dddFoneFixo) {
		this.dddFoneFixo = dddFoneFixo;
	}

	public String getFoneCelular() {
		return foneCelular;
	}

	public void setFoneCelular(String foneCelular) {
		this.foneCelular = foneCelular;
	}

	public String getFoneFixo() {
		return foneFixo;
	}

	public void setFoneFixo(String foneFixo) {
		this.foneFixo = foneFixo;
	}

	public String getLoginDivulgador() {
		return loginDivulgador;
	}

	public void setLoginDivulgador(String loginDivulgador) {
		this.loginDivulgador = loginDivulgador;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(String numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

	public String getAgenciaBanco() {
		return agenciaBanco;
	}

	public void setAgenciaBanco(String agenciaBanco) {
		this.agenciaBanco = agenciaBanco;
	}

	public String getContaBanco() {
		return contaBanco;
	}

	public void setContaBanco(String contaBanco) {
		this.contaBanco = contaBanco;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getOperacaoBanco() {
		return operacaoBanco;
	}

	public void setOperacaoBanco(String operacaoBanco) {
		this.operacaoBanco = operacaoBanco;
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

	public Integer getIsAdministrador() {
		return isAdministrador;
	}

	public void setIsAdministrador(Integer isAdministrador) {
		this.isAdministrador = isAdministrador;
	}

	public Integer getIsEditor() {
		return isEditor;
	}

	public void setIsEditor(Integer isEditor) {
		this.isEditor = isEditor;
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

	public String getPaypal() {
		return paypal;
	}

	public void setPaypal(String paypal) {
		this.paypal = paypal;
	}

	public String getPagseguro() {
		return pagseguro;
	}

	public void setPagseguro(String pagseguro) {
		this.pagseguro = pagseguro;
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

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
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

	public String getEmailIndicador() {
		return emailIndicador;
	}

	public void setEmailIndicador(String emailIndicador) {
		this.emailIndicador = emailIndicador;
	}

}
