#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the tb_patrocinador database table.
 * 
 */
@Entity
@Table(name = "tb_patrocinador")
@NamedQuery(name = "Patrocinador.findAll", query = "SELECT p FROM Patrocinador p")
public class Patrocinador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPatrocinador;

	private String bairro;

	private String cep;

	private String cidade;

	private String cnpj;

	private String complemento;

	private String endereco;

	private String estado;

	private int idResponsavel;

	private String nomeFantasia;

	private String numero;

	private String pais;

	private String razaoSocial;

	private String tipoPessoa;

	// bi-directional many-to-one association to Colaborador
	@OneToMany(mappedBy = "tbPatrocinador")
	private List<Colaborador> tbColaboradors;

	// bi-directional many-to-one association to Patrocinio
	@OneToMany(mappedBy = "patrocinador")
	private List<Patrocinio> patrocinios;

	public Patrocinador() {
	}

	public Long getIdPatrocinador() {
		return this.idPatrocinador;
	}

	public void setIdPatrocinador(Long idPatrocinador) {
		this.idPatrocinador = idPatrocinador;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdResponsavel() {
		return this.idResponsavel;
	}

	public void setIdResponsavel(int idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<Colaborador> getTbColaboradors() {
		return this.tbColaboradors;
	}

	public void setTbColaboradors(List<Colaborador> tbColaboradors) {
		this.tbColaboradors = tbColaboradors;
	}

	public Colaborador addTbColaborador(Colaborador tbColaborador) {
		getTbColaboradors().add(tbColaborador);
		tbColaborador.setTbPatrocinador(this);

		return tbColaborador;
	}

	public Colaborador removeTbColaborador(Colaborador tbColaborador) {
		getTbColaboradors().remove(tbColaborador);
		tbColaborador.setTbPatrocinador(null);

		return tbColaborador;
	}

	public List<Patrocinio> getTbPatrocinios() {
		return this.patrocinios;
	}

	public void setTbPatrocinios(List<Patrocinio> tbPatrocinios) {
		this.patrocinios = tbPatrocinios;
	}

	public Patrocinio addTbPatrocinio(Patrocinio tbPatrocinio) {
		getTbPatrocinios().add(tbPatrocinio);
		tbPatrocinio.setTbPatrocinador(this);

		return tbPatrocinio;
	}

	public Patrocinio removeTbPatrocinio(Patrocinio tbPatrocinio) {
		getTbPatrocinios().remove(tbPatrocinio);
		tbPatrocinio.setTbPatrocinador(null);

		return tbPatrocinio;
	}

}