#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Fernando Pires
 *
 */
@Entity
@Table(name = "tb_metrica_conteudo")
public class MetricaTexto implements Serializable {
	private static final long serialVersionUID = 9070268442413512663L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMetricaTexto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idTexto")
	private Texto texto;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataMetrica")
	private Date dataMetrica;

	private Integer uniquePageViews;

	private Integer averageTime;

	public Long getIdMetricaTexto() {
		return idMetricaTexto;
	}

	public void setIdMetricaTexto(Long idMetricaTexto) {
		this.idMetricaTexto = idMetricaTexto;
	}

	public Texto getTexto() {
		return texto;
	}

	public void setTexto(Texto texto) {
		this.texto = texto;
	}

	public Date getDataMetrica() {
		return dataMetrica;
	}

	public void setDataMetrica(Date dataMetrica) {
		this.dataMetrica = dataMetrica;
	}

	public Integer getUniquePageViews() {
		return uniquePageViews;
	}

	public void setUniquePageViews(Integer uniquePageViews) {
		this.uniquePageViews = uniquePageViews;
	}

	public Integer getAverageTime() {
		return averageTime;
	}

	public void setAverageTime(Integer averageTime) {
		this.averageTime = averageTime;
	}

}