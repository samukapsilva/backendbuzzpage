#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.vo;

import java.io.Serializable;

public class LocalVO implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private Long idRegiao;
	private Long idPagina;
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
	
	public Long getIdRegiao() {
		return idRegiao;
	}
	public void setIdRegiao(Long idRegiao) {
		this.idRegiao = idRegiao;
	}
	public Long getIdPagina() {
		return idPagina;
	}
	public void setIdPagina(Long idPagina) {
		this.idPagina = idPagina;
	}
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
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
}