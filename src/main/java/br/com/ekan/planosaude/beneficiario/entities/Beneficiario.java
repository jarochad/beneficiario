package br.com.ekan.planosaude.beneficiario.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "TB_BENEFICIARIO")
public class Beneficiario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1172590738234275695L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "TELEFONE")
	private String telefone;
	@Column(name = "DATA_NASCIMENTO")
	private Date dataNascimento;
	@Column(name = "DATA_INCLUSAO")
	private	Date dataInclusao;
	@Column(name = "DATA_ATUALIZACAO")
	private Date dataAtualizacao;
	
	@OneToMany(mappedBy = "beneficiario", orphanRemoval =  true, cascade =  CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Documento> listaDocumento;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public List<Documento> getListaDocumento() {
		return listaDocumento;
	}
	public void setListaDocumento(List<Documento> listaDocumento) {
		this.listaDocumento = listaDocumento;
	}

	
}
