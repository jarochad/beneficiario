package br.com.ekan.planosaude.beneficiario.model;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@CreationTimestamp
	private	Date dataInclusao;
	
	@Column(name = "DATA_ATUALIZACAO")
	@UpdateTimestamp
	private Date dataAtualizacao;
	
	@Column
	private String uuid;
	
	@ManyToOne
	@JoinColumn(name = "beneficiario_id")
	private Beneficiario beneficiario;

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
