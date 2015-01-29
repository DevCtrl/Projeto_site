package com.jor.site.modelo;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.jor.site.controle.Control_produto;
import com.jor.site.controle.Control_venda;
import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.Venda;

@ManagedBean(name="ben")
@RequestScoped
public class Ben_vendas {
   
	Produto pd = new Produto();
	Cliente cli = new Cliente();
	Venda vd = new Venda();
	Control_produto comando = new Control_produto();
	Control_venda comandoVd = new Control_venda();
	List lisPro = new ArrayList();
	List lisCarrinho = new ArrayList();
	private int quantidade = 1;
	
		
	public void AddCarrinho(ActionEvent evt)
	{
		System.out.println(pd.getNome());		
	   	lisCarrinho.add(pd);
	}
	public void Remover()
	{
		lisCarrinho.remove(pd);
	}
	public void FinalizarCompra()
	{
		vd.setCliente(cli);
		vd.setProduto(pd);
		vd.setData(new Date());
		comandoVd.inserir(vd);
	}
	public void BuscaProduto(ActionEvent evt)
	{
		lisPro = comando.BuscaProduto(pd.getNome());
	}
	
	
	
	public Produto getPd() {
		return pd;
	}
	public void setPd(Produto pd) {
		this.pd = pd;
	}
	public List getLisPro() {
		return lisPro = new Control_produto().Listar_Dados();
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
	

	

	
	
}
