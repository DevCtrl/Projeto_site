package com.jor.site.entidade;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contrato")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	
	@ManyToOne
	@JoinColumn(name="id_parceria")	
	private Parceria parceria;
	
	@Column(name="nome")
	private String Nome;
	@Column(name="descricao")
	private String Descricao;
	@Column(name="datainicial")
	private String DataInicial;
	@Column(name="datafinal")
	private String DataFinal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public String getDataInicial() {
		return DataInicial;
	}
	public void setDataInicial(String dataInicial) {
		DataInicial = dataInicial;
	}
	public String getDataFinal() {
		return DataFinal;
	}
	public void setDataFinal(String dataFinal) {
		DataFinal = dataFinal;
	}
	

	
}
