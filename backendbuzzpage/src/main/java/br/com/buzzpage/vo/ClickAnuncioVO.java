package br.com.buzzpage.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class ClickAnuncioVO implements Serializable {

	private static final long serialVersionUID = -8181450269574233391L;

	private Long idClickAnuncio;
	private Long idBanner;
	private String ipUsuario;
	private String pagina;
	private Timestamp dataClick;
	private String sessionID;
	private String geolocalizacao;
	private String tipoDispositivo;

	public Long getIdClickAnuncio() {
		return idClickAnuncio;
	}

	public void setIdClickAnuncio(Long idClickAnuncio) {
		this.idClickAnuncio = idClickAnuncio;
	}

	public Long getIdBanner() {
		return idBanner;
	}

	public void setIdBanner(Long idBanner) {
		this.idBanner = idBanner;
	}

	public String getIpUsuario() {
		return ipUsuario;
	}

	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public Timestamp getDataClick() {
		return dataClick;
	}

	public void setDataClick(Timestamp dataClick) {
		this.dataClick = dataClick;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String getGeolocalizacao() {
		return geolocalizacao;
	}

	public void setGeolocalizacao(String geolocalizacao) {
		this.geolocalizacao = geolocalizacao;
	}

	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}
}