#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the tb_coautor database table.
 * 
 */
@Entity
@Table(name = "tb_coautor")
@NamedQuery(name = "Coautor.findAll", query = "SELECT c FROM Coautor c")
public class Coautor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCoAutor;

	@Temporal(TemporalType.DATE)
	private Date dataAceite;

	@Temporal(TemporalType.DATE)
	private Date dataConvite;

	@Temporal(TemporalType.DATE)
	private Date dataRemocao;

	private int idTexto;

	private short permissaoPublicar;

	private byte status;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPessoa")
	private Pessoa tbPessoa;

	public Coautor() {
	}

	public Date getDataAceite() {
		return this.dataAceite;
	}

	public void setDataAceite(Date dataAceite) {
		this.dataAceite = dataAceite;
	}

	public Date getDataConvite() {
		return this.dataConvite;
	}

	public void setDataConvite(Date dataConvite) {
		this.dataConvite = dataConvite;
	}

	public Date getDataRemocao() {
		return this.dataRemocao;
	}

	public void setDataRemocao(Date dataRemocao) {
		this.dataRemocao = dataRemocao;
	}

	public int getIdTexto() {
		return this.idTexto;
	}

	public void setIdTexto(int idTexto) {
		this.idTexto = idTexto;
	}

	public short getPermissaoPublicar() {
		return this.permissaoPublicar;
	}

	public void setPermissaoPublicar(short permissaoPublicar) {
		this.permissaoPublicar = permissaoPublicar;
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

	public Long getIdCoAutor() {
		return idCoAutor;
	}

	public void setIdCoAutor(Long idCoAutor) {
		this.idCoAutor = idCoAutor;
	}

}