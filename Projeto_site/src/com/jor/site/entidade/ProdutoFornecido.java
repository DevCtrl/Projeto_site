package com.jor.site.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="produtoFornecido")
public class ProdutoFornecido {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="id_parceria")	
	private Parceria parceria;	
	
	@Column (name="nome")
	private String Nome;	
	@Column(name="valor_Varejo")
	private Double Valor_Varejo;	
	@Column(name="quantidade")	
	private Integer Quantidade;	
	@Column(name="dataCadastro")
	private String DataCadastro;
	@Column(name="dataContas")
	private String DataContas;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Parceria getParceria() {
		return parceria;
	}
	public void setParceria(Parceria parceria) {
		this.parceria = parceria;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Double getValor_Varejo() {
		return Valor_Varejo;
	}
	public void setValor_Varejo(Double valor_Varejo) {
		Valor_Varejo = valor_Varejo;
	}
	public Integer getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		Quantidade = quantidade;
	}
	public String getDataCadastro() {
		return DataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		DataCadastro = dataCadastro;
	}
	public String getDataContas() {
		return DataContas;
	}
	public void setDataContas(String dataContas) {
		DataContas = dataContas;
	}
	
	
	
	
	
	

}
