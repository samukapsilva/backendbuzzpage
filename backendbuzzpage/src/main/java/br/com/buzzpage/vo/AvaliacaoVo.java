
package br.com.buzzpage.vo;

import java.util.Date;

public class AvaliacaoVo {

	private Long id;
	private Byte coesaoTextual;
	private String comentDivisaoParagrafos;
	private String comentQualidadeTitulo;
	private Date dataRevisao;
	private String descErroPlagio;
	private String descErrosGramaticais;
	private String descErrosOrtograficos;
	private Byte divisaoParagrafos;

	private Boolean erroPlagio;
	private Boolean errosGramaticais;
	private Boolean errosOrtograficos;

	private Byte escaneabilidade;
	private Byte estruturaConteudo;
	private Byte geralFrases;
	private Long idConteudo;
	private Long idRevisor;
	private Byte qualidadeIntroducao;
	private Byte qualidadeTitulo;
	private Byte relacionamentoPalavra;
	private String sugestCoesaoTextual;
	private String sugestEscaneabilidade;
	private String sugestEstruturaConteudo;
	private String sugestGeralFrases;
	private String sugestQualidadeIntroducao;
	private String sugestRelacionamentoPalavra;
	private String sugestUsoSinonimos;
	private Byte usoSinonimos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte getCoesaoTextual() {
		return coesaoTextual;
	}

	public void setCoesaoTextual(Byte coesaoTextual) {
		this.coesaoTextual = coesaoTextual;
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

	public Date getDataRevisao() {
		return dataRevisao;
	}

	public void setDataRevisao(Date dataRevisao) {
		this.dataRevisao = dataRevisao;
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

	@Override
	public String toString() {
		return "AvaliacaoVo [id=" + id + ", coesaoTextual=" + coesaoTextual + ", comentDivisaoParagrafos="
				+ comentDivisaoParagrafos + ", comentQualidadeTitulo=" + comentQualidadeTitulo + ", dataRevisao="
				+ dataRevisao + ", descErroPlagio=" + descErroPlagio + ", descErrosGramaticais=" + descErrosGramaticais
				+ ", descErrosOrtograficos=" + descErrosOrtograficos + ", divisaoParagrafos=" + divisaoParagrafos
				+ ", erroPlagio=" + erroPlagio + ", errosGramaticais=" + errosGramaticais + ", errosOrtograficos="
				+ errosOrtograficos + ", escaneabilidade=" + escaneabilidade + ", estruturaConteudo="
				+ estruturaConteudo + ", geralFrases=" + geralFrases + ", idConteudo=" + idConteudo + ", idRevisor="
				+ idRevisor + ", qualidadeIntroducao=" + qualidadeIntroducao + ", qualidadeTitulo=" + qualidadeTitulo
				+ ", relacionamentoPalavra=" + relacionamentoPalavra + ", sugestCoesaoTextual=" + sugestCoesaoTextual
				+ ", sugestEscaneabilidade=" + sugestEscaneabilidade + ", sugestEstruturaConteudo="
				+ sugestEstruturaConteudo + ", sugestGeralFrases=" + sugestGeralFrases + ", sugestQualidadeIntroducao="
				+ sugestQualidadeIntroducao + ", sugestRelacionamentoPalavra=" + sugestRelacionamentoPalavra
				+ ", sugestUsoSinonimos=" + sugestUsoSinonimos + ", usoSinonimos=" + usoSinonimos + "]";
	}

}
