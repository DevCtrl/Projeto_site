package com.jor.site.modelo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.jor.site.controle.Control_cliente;
import com.jor.site.controle.Control_produto;
import com.jor.site.controle.Control_venda;
import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.Venda;
import com.jor.site.util.Alertas;

@ManagedBean(name="benS")
@SessionScoped
public class Ben_sistema {
   
	Produto pd = new Produto();
	Cliente cli = new Cliente();
	Cliente CliPesquisado = new Cliente();
	Venda vd = new Venda();
	Control_produto comando = new Control_produto();
	Control_cliente comandoCli = new Control_cliente();
	Control_venda comandoVd = new Control_venda();
	List lisPro = new ArrayList();
	List<Produto> lisCarrinho = new ArrayList<Produto>();
	private String ClientePesquisa;
	private int quantidade = 1;
	private double subtotal=0;
	private double total=0;
	
	
	

		

	
	
	public Produto getPd() {
		return pd;
	}
	public void setPd(Produto pd) {
		this.pd = pd;
	}	
	public List getLisPro() {
		return lisPro;
	}
	public void setLisPro(List lisPro) {
		this.lisPro = lisPro;
	}
	public List getLisCarrinho() {
		return lisCarrinho;
	}
	public void setLisCarrinho(List lisCarrinho) {
		this.lisCarrinho = lisCarrinho;
	}
	public Cliente getCli() {
		return cli;
	}
	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	public Venda getVd() {
		return vd;
	}
	public void setVd(Venda vd) {
		this.vd = vd;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getClientePesquisa() {
		return ClientePesquisa;
	}

	public void setClientePesquisa(String clientePesquisa) {
		ClientePesquisa = clientePesquisa;
	}
	

	

	
	
}








































  
