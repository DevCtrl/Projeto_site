package com.jor.site.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column 
	private String nome;
	@Column
	private String descricao;
	@Column
	private Double valor_Varejo;
	@Column
	private Double valor_Revenda;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor_Varejo() {
		return valor_Varejo;
	}
	public void setValor_Varejo(Double valor_Varejo) {
		this.valor_Varejo = valor_Varejo;
	}
	public Double getValor_Revenda() {
		return valor_Revenda;
	}
	public void setValor_Revenda(Double valor_Revenda) {
		this.valor_Revenda = valor_Revenda;
	}
	
	
	

}
