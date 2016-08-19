package br.com.buzzpage.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;

import br.com.buzzpage.entity.Usuario;

public class AnuncioVO implements Serializable {

	private static final long serialVersionUID = -3988743594179814380L;

	private Long 	idAnuncio;
	private String  dataInicio;
	private String dataFinal;	
	private Long idEmpresa;
	private Double valor;
 
	
	private List<LocalVO> locais;
	
	public Long getIdAnuncio() {
		return idAnuncio;
	}
	
	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

 
	public List<LocalVO> getLocais() {
		return locais;
	}

	public void setLocais(List<LocalVO> locais) {
		this.locais = locais;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}	
}