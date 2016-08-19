#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the tb_colaborador database table.
 * 
 */
@Entity
@Table(name = "tb_colaborador")
@NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c")
public class Colaborador implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ColaboradorPK id;

	@Temporal(TemporalType.DATE)
	private Date dataAceiteConvite;

	@Temporal(TemporalType.DATE)
	private Date dataConvite;

	@Temporal(TemporalType.DATE)
	private Date dataFimVinculo;

	@Temporal(TemporalType.DATE)
	private Date dataInicioVinculo;

	private byte status;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPessoa", insertable = false, updatable = false)
	private Pessoa tbPessoa;

	// bi-directional many-to-one association to Patrocinador
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPatrocinador", insertable = false, updatable = false)
	private Patrocinador tbPatrocinador;

	public Colaborador() {
	}

	public ColaboradorPK getId() {
		return this.id;
	}

	public void setId(ColaboradorPK id) {
		this.id = id;
	}

	public Date getDataAceiteConvite() {
		return this.dataAceiteConvite;
	}

	public void setDataAceiteConvite(Date dataAceiteConvite) {
		this.dataAceiteConvite = dataAceiteConvite;
	}

	public Date getDataConvite() {
		return this.dataConvite;
	}

	public void setDataConvite(Date dataConvite) {
		this.dataConvite = dataConvite;
	}

	public Date getDataFimVinculo() {
		return this.dataFimVinculo;
	}

	public void setDataFimVinculo(Date dataFimVinculo) {
		this.dataFimVinculo = dataFimVinculo;
	}

	public Date getDataInicioVinculo() {
		return this.dataInicioVinculo;
	}

	public void setDataInicioVinculo(Date dataInicioVinculo) {
		this.dataInicioVinculo = dataInicioVinculo;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Pessoa getTbPessoa() {
		return this.tbPessoa;
	}

	public void setTbPessoa(Pessoa tbPessoa) {
		this.tbPessoa = tbPessoa;
	}

	public Patrocinador getTbPatrocinador() {
		return this.tbPatrocinador;
	}

	public void setTbPatrocinador(Patrocinador tbPatrocinador) {
		this.tbPatrocinador = tbPatrocinador;
	}

}