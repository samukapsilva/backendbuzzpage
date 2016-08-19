#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the tb_avaliacao_conteudo database table.
 * 
 */
@Entity
@Table(name = "tb_avaliacao_conteudo")
@NamedQuery(name = "Avaliacao.findAll", query = "SELECT t FROM Avaliacao t")
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRevisao;

	private Long idConteudo;

	private Long idRevisor;

	@Lob
	private String comentDivisaoParagrafos;

	@Lob
	private String comentQualidadeTitulo;

	private Byte coesaoTextual;

	@Lob
	private String descErroPlagio;

	private String descErrosGramaticais;

	@Lob
	private String descErrosOrtograficos;

	private Byte divisaoParagrafos;

	private Boolean erroPlagio;
	private Boolean errosGramaticais;
	private Boolean errosOrtograficos;

	private Byte escaneabilidade;

	private Byte estruturaConteudo;

	private Byte geralFrases;

	private Byte qualidadeIntroducao;

	private Byte qualidadeTitulo;

	private Byte relacionamentoPalavra;

	@Lob
	private String sugestCoesaoTextual;

	@Lob
	private String sugestEscaneabilidade;

	@Lob
	private String sugestEstruturaConteudo;

	@Lob
	private String sugestGeralFrases;

	@Lob
	private String sugestQualidadeIntroducao;

	@Lob
	private String sugestRelacionamentoPalavra;

	@Lob
	private String sugestUsoSinonimos;

	private Byte usoSinonimos;

	public Avaliacao() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataRevisao() {
		return dataRevisao;
	}

	public void setDataRevisao(Date dataRevisao) {
		this.dataRevisao = dataRevisao;
	}

	public Long getIdConteudo() {
		return idConteudo;
	}

	public void setIdConteudo(Long idConteudo) {
		this.idConteudo = idConteudo;
	}

	public Long getIdRevisor() {
		return idRevisor;
	}

	public void setIdRevisor(Long idRevisor) {
		this.idRevisor = idRevisor;
	}

	public String getComentDivisaoParagrafos() {
		return comentDivisaoParagrafos;
	}

	public void setComentDivisaoParagrafos(String comentDivisaoParagrafos) {
		this.comentDivisaoParagrafos = comentDivisaoParagrafos;
	}

	public String getComentQualidadeTitulo() {
		return comentQualidadeTitulo;
	}

	public void setComentQualidadeTitulo(String comentQualidadeTitulo) {
		this.comentQualidadeTitulo = comentQualidadeTitulo;
	}

	public Byte getCoesaoTextual() {
		return coesaoTextual;
	}

	public void setCoesaoTextual(Byte coesaoTextual) {
		this.coesaoTextual = coesaoTextual;
	}

	public String getDescErroPlagio() {
		return descErroPlagio;
	}

	public void setDescErroPlagio(String descErroPlagio) {
		this.descErroPlagio = descErroPlagio;
	}

	public String getDescErrosGramaticais() {
		return descErrosGramaticais;
	}

	public void setDescErrosGramaticais(String descErrosGramaticais) {
		this.descErrosGramaticais = descErrosGramaticais;
	}

	public String getDescErrosOrtograficos() {
		return descErrosOrtograficos;
	}

	public void setDescErrosOrtograficos(String descErrosOrtograficos) {
		this.descErrosOrtograficos = descErrosOrtograficos;
	}

	public Byte getDivisaoParagrafos() {
		return divisaoParagrafos;
	}

	public void setDivisaoParagrafos(Byte divisaoParagrafos) {
		this.divisaoParagrafos = divisaoParagrafos;
	}

	public Boolean getErroPlagio() {
		return erroPlagio;
	}

	public void setErroPlagio(Boolean erroPlagio) {
		this.erroPlagio = erroPlagio;
	}

	public Boolean getErrosGramaticais() {
		return errosGramaticais;
	}

	public void setErrosGramaticais(Boolean errosGramaticais) {
		this.errosGramaticais = errosGramaticais;
	}

	public Boolean getErrosOrtograficos() {
		return errosOrtograficos;
	}

	public void setErrosOrtograficos(Boolean errosOrtograficos) {
		this.errosOrtograficos = errosOrtograficos;
	}

	public Byte getEscaneabilidade() {
		return escaneabilidade;
	}

	public void setEscaneabilidade(Byte escaneabilidade) {
		this.escaneabilidade = escaneabilidade;
	}

	public Byte getEstruturaConteudo() {
		return estruturaConteudo;
	}

	public void setEstruturaConteudo(Byte estruturaConteudo) {
		this.estruturaConteudo = estruturaConteudo;
	}

	public Byte getGeralFrases() {
		return geralFrases;
	}

	public void setGeralFrases(Byte geralFrases) {
		this.geralFrases = geralFrases;
	}

	public Byte getQualidadeIntroducao() {
		return qualidadeIntroducao;
	}

	public void setQualidadeIntroducao(Byte qualidadeIntroducao) {
		this.qualidadeIntroducao = qualidadeIntroducao;
	}

	public Byte getQualidadeTitulo() {
		return qualidadeTitulo;
	}

	public void setQualidadeTitulo(Byte qualidadeTitulo) {
		this.qualidadeTitulo = qualidadeTitulo;
	}

	public Byte getRelacionamentoPalavra() {
		return relacionamentoPalavra;
	}

	public void setRelacionamentoPalavra(Byte relacionamentoPalavra) {
		this.relacionamentoPalavra = relacionamentoPalavra;
	}

	public String getSugestCoesaoTextual() {
		return sugestCoesaoTextual;
	}

	public void setSugestCoesaoTextual(String sugestCoesaoTextual) {
		this.sugestCoesaoTextual = sugestCoesaoTextual;
	}

	public String getSugestEscaneabilidade() {
		return sugestEscaneabilidade;
	}

	public void setSugestEscaneabilidade(String sugestEscaneabilidade) {
		this.sugestEscaneabilidade = sugestEscaneabilidade;
	}

	public String getSugestEstruturaConteudo() {
		return sugestEstruturaConteudo;
	}

	public void setSugestEstruturaConteudo(String sugestEstruturaConteudo) {
		this.sugestEstruturaConteudo = sugestEstruturaConteudo;
	}

	public String getSugestGeralFrases() {
		return sugestGeralFrases;
	}

	public void setSugestGeralFrases(String sugestGeralFrases) {
		this.sugestGeralFrases = sugestGeralFrases;
	}

	public String getSugestQualidadeIntroducao() {
		return sugestQualidadeIntroducao;
	}

	public void setSugestQualidadeIntroducao(String sugestQualidadeIntroducao) {
		this.sugestQualidadeIntroducao = sugestQualidadeIntroducao;
	}

	public String getSugestRelacionamentoPalavra() {
		return sugestRelacionamentoPalavra;
	}

	public void setSugestRelacionamentoPalavra(String sugestRelacionamentoPalavra) {
		this.sugestRelacionamentoPalavra = sugestRelacionamentoPalavra;
	}

	public String getSugestUsoSinonimos() {
		return sugestUsoSinonimos;
	}

	public void setSugestUsoSinonimos(String sugestUsoSinonimos) {
		this.sugestUsoSinonimos = sugestUsoSinonimos;
	}

	public Byte getUsoSinonimos() {
		return usoSinonimos;
	}

	public void setUsoSinonimos(Byte usoSinonimos) {
		this.usoSinonimos = usoSinonimos;
	}

}