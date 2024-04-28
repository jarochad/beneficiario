package br.com.ekan.planosaude.beneficiario.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
	@CreationTimestamp
	private	Date dataInclusao;

	@Column(name = "DATA_ATUALIZACAO")
	@UpdateTimestamp
	private Date dataAtualizacao;

	@Column
	private String uuid;
	
	@OneToMany(mappedBy = "beneficiario",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Documento> documentos;

	@PrePersist  
	protected void onCreate() {
		dataInclusao = new Date();
		uuid = UUID.randomUUID().toString();
	}

	@PreUpdate 
	protected void onUpdate() {
		dataAtualizacao = new Date();
	}

}
