package br.com.buzzpage.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

/**
 * The persistent class for the tb_pessoa database table.
 * 
 */
@Entity
@Table(name = "tb_pessoa")
@NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa; // ok

	private String bairro;

	private String cep;

	private String cidade;

	private String complemento;

	private String dddFoneCelular;

	private String dddFoneFixo;

	private String email;

	private String endereco;

	private String estado;

	private String foneCelular;

	private String foneFixo;

	private Long idSexo;

	private String loginDivulgador;

	private String nome;

	private String numero;

	private String numeroDocumento;

	private String numeroRG;

	private String pais;

	private String senha;

	private Integer tipoDocumento;

	private String usuario;

	private String numeroBanco;
	private String agenciaBanco;
	private String contaBanco;
	private String tipoConta;
	private String operacaoBanco;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataAceite")
	private Date dataAceite;

	private String ipAceite;

	private Integer isAdministrador;

	private Integer isEditor;

	private Integer diaAniversario;
	private Integer mesAniversario;
	private Integer anoAniversario;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataCadastro")
	private Date dataCadastro;

	// bi-directional many-to-one association to Coautor
	@OneToMany(mappedBy = "tbPessoa")
	private List<Coautor> tbCoautors;

	// bi-directional many-to-one association to Colaborador
	@OneToMany(mappedBy = "tbPessoa")
	private List<Colaborador> tbColaboradors;

	// bi-directional many-to-one association to Texto
	@OneToMany(mappedBy = "pessoa")
	private List<Texto> textos;

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
	private String fotoPerfil;

	@Column(name = "aceiteTermos", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean aceiteTermos;

	@Column(name = "publicarRedes", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean publicarRedes;

	@Column(name = "publicarSite", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean publicarSite;

	@Column(name = "publicarAutoria", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean publicarAutoria;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idIndicador")
	private Pessoa indicador;

	// idIndicador

	public Pessoa() {
	}

	public Long getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getDddFoneCelular() {
		return this.dddFoneCelular;
	}

	public void setDddFoneCelular(String dddFoneCelular) {
		this.dddFoneCelular = dddFoneCelular;
	}

	public String getDddFoneFixo() {
		return this.dddFoneFixo;
	}

	public void setDddFoneFixo(String dddFoneFixo) {
		this.dddFoneFixo = dddFoneFixo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFoneCelular() {
		return this.foneCelular;
	}

	public void setFoneCelular(String foneCelular) {
		this.foneCelular = foneCelular;
	}

	public String getFoneFixo() {
		return this.foneFixo;
	}

	public void setFoneFixo(String foneFixo) {
		this.foneFixo = foneFixo;
	}

	public Long getIdSexo() {
		return this.idSexo;
	}

	public void setIdSexo(Long idSexo) {
		this.idSexo = idSexo;
	}

	public String getLoginDivulgador() {
		return this.loginDivulgador;
	}

	public void setLoginDivulgador(String loginDivulgador) {
		this.loginDivulgador = loginDivulgador;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNumeroRG() {
		return this.numeroRG;
	}

	public void setNumeroRG(String numeroRG) {
		this.numeroRG = numeroRG;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Coautor> getTbCoautors() {
		return this.tbCoautors;
	}

	public void setTbCoautors(List<Coautor> tbCoautors) {
		this.tbCoautors = tbCoautors;
	}

	public Coautor addTbCoautor(Coautor tbCoautor) {
		getTbCoautors().add(tbCoautor);
		tbCoautor.setTbPessoa(this);

		return tbCoautor;
	}

	public Coautor removeTbCoautor(Coautor tbCoautor) {
		getTbCoautors().remove(tbCoautor);
		tbCoautor.setTbPessoa(null);

		return tbCoautor;
	}

	public List<Colaborador> getTbColaboradors() {
		return this.tbColaboradors;
	}

	public List<Texto> getTbTextos() {
		return this.textos;
	}

	public void setTbTextos(List<Texto> tbTextos) {
		this.textos = tbTextos;
	}

	public Texto addTbTexto(Texto tbTexto) {
		getTbTextos().add(tbTexto);
		tbTexto.setPessoa(this);

		return tbTexto;
	}

	public Texto removeTbTexto(Texto tbTexto) {
		getTbTextos().remove(tbTexto);
		tbTexto.setPessoa(null);

		return tbTexto;
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

	public List<Texto> getTextos() {
		return textos;
	}

	public void setTextos(List<Texto> textos) {
		this.textos = textos;
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

	public Integer getDiaAniversario() {
		return diaAniversario;
	}

	public void setDiaAniversario(Integer diaAniversario) {
		this.diaAniversario = diaAniversario;
	}

	public Integer getMesAniversario() {
		return mesAniversario;
	}

	public void setMesAniversario(Integer mesAniversario) {
		this.mesAniversario = mesAniversario;
	}

	public Integer getAnoAniversario() {
		return anoAniversario;
	}

	public void setAnoAniversario(Integer anoAniversario) {
		this.anoAniversario = anoAniversario;
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

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAceite() {
		return dataAceite;
	}

	public void setDataAceite(Date dataAceite) {
		this.dataAceite = dataAceite;
	}

	public String getIpAceite() {
		return ipAceite;
	}

	public void setIpAceite(String ipAceite) {
		this.ipAceite = ipAceite;
	}

	public Pessoa getIndicador() {
		return indicador;
	}

	public void setIndicador(Pessoa indicador) {
		this.indicador = indicador;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", bairro=" + bairro + ", cep="
				+ cep + ", cidade=" + cidade + ", complemento=" + complemento
				+ ", dddFoneCelular=" + dddFoneCelular + ", dddFoneFixo="
				+ dddFoneFixo + ", email=" + email + ", endereco=" + endereco
				+ ", estado=" + estado + ", foneCelular=" + foneCelular
				+ ", foneFixo=" + foneFixo + ", idSexo=" + idSexo
				+ ", loginDivulgador=" + loginDivulgador + ", nome=" + nome
				+ ", numero=" + numero + ", numeroDocumento=" + numeroDocumento
				+ ", numeroRG=" + numeroRG + ", pais=" + pais + ", senha="
				+ senha + ", tipoDocumento=" + tipoDocumento + ", usuario="
				+ usuario + ", numeroBanco=" + numeroBanco + ", agenciaBanco="
				+ agenciaBanco + ", contaBanco=" + contaBanco + ", tipoConta="
				+ tipoConta + ", operacaoBanco=" + operacaoBanco
				+ ", dataAceite=" + dataAceite + ", ipAceite=" + ipAceite
				+ ", isAdministrador=" + isAdministrador + ", isEditor="
				+ isEditor + ", diaAniversario=" + diaAniversario
				+ ", mesAniversario=" + mesAniversario + ", anoAniversario="
				+ anoAniversario + ", dataCadastro=" + dataCadastro
				+ ", linkedin=" + linkedin + ", twitter=" + twitter
				+ ", blogger=" + blogger + ", youtube=" + youtube
				+ ", googleMais=" + googleMais + ", site=" + site + ", paypal="
				+ paypal + ", pagseguro=" + pagseguro + ", fotoPerfil="
				+ fotoPerfil + ", aceiteTermos=" + aceiteTermos
				+ ", publicarRedes=" + publicarRedes + ", publicarSite="
				+ publicarSite + ", publicarAutoria=" + publicarAutoria + "]";
	}

}