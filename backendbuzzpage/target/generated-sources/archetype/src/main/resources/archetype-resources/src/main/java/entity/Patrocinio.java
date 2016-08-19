#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the tb_patrocinio database table.
 * 
 */
@Entity
@SuppressWarnings("restriction")
@XmlRootElement
@Table(name = "tb_patrocinio")
@NamedQuery(name = "Patrocinio.findAll", query = "SELECT p FROM Patrocinio p")
public class Patrocinio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPatrocinio;

	@Temporal(TemporalType.DATE)
	private Date dataFimPatrocinio;

	@Temporal(TemporalType.DATE)
	private Date dataInicioPatrocinio;

	private int idRegiao;

	private String statusPatrocinio;

	// bi-directional many-to-one association to Patrocinador
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPatrocinador")
	private Patrocinador patrocinador;

	// bi-directional many-to-one association to Pagina
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPagina")
	private Pagina pagina;

	// bi-directional many-to-one association to Texto
	@OneToMany(mappedBy = "patrocinio")
	private List<Texto> textos;

	public Patrocinio() {
	}

	public Long getIdPatrocinio() {
		return this.idPatrocinio;
	}

	public void setIdPatrocinio(Long idPatrocinio) {
		this.idPatrocinio = idPatrocinio;
	}

	public Date getDataFimPatrocinio() {
		return this.dataFimPatrocinio;
	}

	public void setDataFimPatrocinio(Date dataFimPatrocinio) {
		this.dataFimPatrocinio = dataFimPatrocinio;
	}

	public Date getDataInicioPatrocinio() {
		return this.dataInicioPatrocinio;
	}

	public void setDataInicioPatrocinio(Date dataInicioPatrocinio) {
		this.dataInicioPatrocinio = dataInicioPatrocinio;
	}

	public int getIdRegiao() {
		return this.idRegiao;
	}

	public void setIdRegiao(int idRegiao) {
		this.idRegiao = idRegiao;
	}

	public String getStatusPatrocinio() {
		return this.statusPatrocinio;
	}

	public void setStatusPatrocinio(String statusPatrocinio) {
		this.statusPatrocinio = statusPatrocinio;
	}

	public Patrocinador getPatrocinador() {
		return this.patrocinador;
	}

	public void setTbPatrocinador(Patrocinador patrocinador) {
		this.patrocinador = patrocinador;
	}

	public Pagina getTbPagina() {
		return this.pagina;
	}

	public void setTbPagina(Pagina tbPagina) {
		this.pagina = tbPagina;
	}

	public List<Texto> getTbTextos() {
		return this.textos;
	}

	public void setTbTextos(List<Texto> tbTextos) {
		this.textos = tbTextos;
	}

	public Texto addTbTexto(Texto tbTexto) {
		getTbTextos().add(tbTexto);
		tbTexto.setPatrocinio(this);

		return tbTexto;
	}

	public Texto removeTbTexto(Texto tbTexto) {
		getTbTextos().remove(tbTexto);
		tbTexto.setPatrocinio(null);

		return tbTexto;
	}

}