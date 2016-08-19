#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

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

@Entity
@Table(name = "tb_conteudo")
@NamedQuery(name = "Texto.findAll", query = "SELECT t FROM Texto t")
public class Texto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTexto;

	private Boolean statusLiberadoPublicar;

	private Boolean statusPublicacao;

	// bi-directional many-to-one association to Mensagem
	@OneToMany(mappedBy = "texto")
	private List<Mensagem> mensagens;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataCadastro")
	private Date dataCadastro;

	// bi-directional many-to-one association to Patrocinio
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPatrocinio")
	private Patrocinio patrocinio;

	// bi-directional many-to-one association to Pagina
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPagina")
	private Pagina pagina;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRedatorPrincipal")
	private Pessoa pessoa;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRevisor")
	private Pessoa revisor;

	private String palavraChave;
	private String sinonimos;
	private String titulo;
	private String resumo;
	private String texto;

	private String fotoDestaque;

	private Boolean flagPublicado;

	private String slug;

	public Texto() {
	}

	public Long getIdTexto() {
		return this.idTexto;
	}

	public void setIdTexto(Long idTexto) {
		this.idTexto = idTexto;
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
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

	public Boolean getStatusLiberadoPublicar() {
		return this.statusLiberadoPublicar;
	}

	public void setStatusLiberadoPublicar(Boolean statusLiberadoPublicar) {
		this.statusLiberadoPublicar = statusLiberadoPublicar;
	}

	public Boolean getStatusPublicacao() {
		return this.statusPublicacao;
	}

	public void setStatusPublicacao(Boolean statusPublicacao) {
		this.statusPublicacao = statusPublicacao;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Patrocinio getPatrocinio() {
		return patrocinio;
	}

	public void setPatrocinio(Patrocinio patrocinio) {
		this.patrocinio = patrocinio;
	}

	public Pagina getPagina() {
		return pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa tbPessoa) {
		this.pessoa = tbPessoa;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Pessoa getRevisor() {
		return revisor;
	}

	public void setRevisor(Pessoa revisor) {
		this.revisor = revisor;
	}

	public String getFotoDestaque() {
		return fotoDestaque;
	}

	public void setFotoDestaque(String fotoDestaque) {
		this.fotoDestaque = fotoDestaque;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Boolean getFlagPublicado() {
		return flagPublicado;
	}

	public void setFlagPublicado(Boolean flagPublicado) {
		this.flagPublicado = flagPublicado;
	}

}