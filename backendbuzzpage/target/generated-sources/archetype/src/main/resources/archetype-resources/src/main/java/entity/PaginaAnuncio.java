#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_paginas_anuncio")
public class PaginaAnuncio implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPaginaAnuncio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPagina")
	private Pagina pagina;
	
	// bi-directional many-to-one association to Regiao
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRegiao")
	private Regiao regiao;
	
	// bi-directional many-to-one association to Anuncio
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAnuncio")
	private Anuncio anuncio;
	
	private Double valor;
	private String banner1;
	private String banner2;	
	private String banner3;
	private String banner4;
	private String banner5;
	
	private String link1;
	private String link2;
	private String link3;
	private String link4;
	private String link5;
	
	
	public Pagina getPagina() {
		return pagina;
	}
	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	
	public Long getIdPaginaAnuncio() {
		return idPaginaAnuncio;
	}
	public void setIdPaginaAnuncio(Long idPaginaAnuncio) {
		this.idPaginaAnuncio = idPaginaAnuncio;
	}
	public String getBanner1() {
		return banner1;
	}
	public void setBanner1(String banner1) {
		this.banner1 = banner1;
	}
	public String getBanner2() {
		return banner2;
	}
	public void setBanner2(String banner2) {
		this.banner2 = banner2;
	}
	public String getBanner3() {
		return banner3;
	}
	public void setBanner3(String banner3) {
		this.banner3 = banner3;
	}
	public String getBanner4() {
		return banner4;
	}
	public void setBanner4(String banner4) {
		this.banner4 = banner4;
	}
	public String getBanner5() {
		return banner5;
	}
	public void setBanner5(String banner5) {
		this.banner5 = banner5;
	}
	public Anuncio getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	public String getLink1() {
		return link1;
	}
	public void setLink1(String link1) {
		this.link1 = link1;
	}
	public String getLink2() {
		return link2;
	}
	public void setLink2(String link2) {
		this.link2 = link2;
	}
	public String getLink3() {
		return link3;
	}
	public void setLink3(String link3) {
		this.link3 = link3;
	}
	public String getLink4() {
		return link4;
	}
	public void setLink4(String link4) {
		this.link4 = link4;
	}
	public String getLink5() {
		return link5;
	}
	public void setLink5(String link5) {
		this.link5 = link5;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}