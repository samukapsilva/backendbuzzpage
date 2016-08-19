package br.com.buzzpage.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the tb_voucher database table.
 * 
 */
@Entity
@Table(name="tb_voucher")
@NamedQuery(name="Voucher.findAll", query="SELECT t FROM Voucher t")
public class Voucher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoucher;

	private String codVoucher;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataGeracao;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;

	private String ipUsuario;

	public Voucher() {
	}

	public Long getIdVoucher() {
		return this.idVoucher;
	}

	public void setIdVoucher(Long idVoucher) {
		this.idVoucher = idVoucher;
	}

	public String getCodVoucher() {
		return this.codVoucher;
	}

	public void setCodVoucher(String codVoucher) {
		this.codVoucher = codVoucher;
	}

	public Date getDataGeracao() {
		return this.dataGeracao;
	}

	public void setDataGeracao(Date dataGeracao) {
		this.dataGeracao = dataGeracao;
	}
	

 
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getIpUsuario() {
		return this.ipUsuario;
	}

	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}

}