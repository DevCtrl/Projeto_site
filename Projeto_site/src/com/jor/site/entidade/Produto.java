package com.jor.site.entidade;

import java.util.Date;

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
	@Column (name="nome")
	private String Nome;
	@Column(name="descricao")
	private String Descricao;
	@Column(name="valor_Varejo")
	private Double Valor_Varejo;
	@Column(name="valor_Revenda")
	private Double Valor_Revenda;
	@Column(name="quantidade")	
	private Integer Quantidade;
	@Column(name="tipo")
	private String Tipo;
	@Column(name="comprado")
	private Double Comprado;
	@Column(name="dataProduto")
	private String DataProduto;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public Double getValor_Varejo() {
		return Valor_Varejo;
	}
	public void setValor_Varejo(Double valor_Varejo) {
		Valor_Varejo = valor_Varejo;
	}
	public Double getValor_Revenda() {
		return Valor_Revenda;
	}
	public void setValor_Revenda(Double valor_Revenda) {
		Valor_Revenda = valor_Revenda;
	}
	public Integer getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		Quantidade = quantidade;
	}
	public Double getComprado() {
		return Comprado;
	}
	public void setComprado(Double comprado) {
		Comprado = comprado;
	}
	public String getDataProduto() {
		return DataProduto;
	}
	public void setDataProduto(String string) {
		DataProduto = string;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	
	
	
	
	

}
