package br.com.ekan.planosaude.beneficiario.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "TB_DOCUMENTO")
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "TIPO_DOCUMENTO")
	private String tipoDocumento;
	@Column(name = "DESCRICAO")
	private String descricao;
	@Column(name = "DATA_INCLUSAO")
	private	Date dataInclusao;
	@Column(name = "DATA_ATUALIZACAO")
	private Date dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name = "BENEFICIARIO_ID", nullable = false)
	private Beneficiario beneficiario;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = new Date();
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = new Date();
	}
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

}
