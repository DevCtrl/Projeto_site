package com.jor.site.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	
	@ManyToOne
	@JoinColumn(name="id_produto")	
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="id_cliente") 
	private Cliente cliente;
	
	@Column
	private Date data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}