package com.jor.site.modelo;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import com.jor.site.controle.Control_produto;
import com.jor.site.entidade.Produto;

@ManagedBean(name="benProduto")
@RequestScoped
public class Ben_produto {
   
	Produto produto = new Produto();
	Control_produto comando = new Control_produto();
	List lista = new ArrayList();
	
	
	
	public String Incluir()
	{
		return "ConfigureProduto.xhtml";
	}	
	public void Cadastrar(ActionEvent evt)
	{
		if(produto.getId()>0)
		{
			comando.inserir(produto);
		}else
		{
			comando.alterar(produto);
		}
		lista = comando.Listar_Dados();
		produto = new Produto();		
		
	}
	public void Deletar(ActionEvent evt)
	{
		comando.deletar(produto);		
		lista = comando.Listar_Dados();
		produto = new Produto();
	}
	public void BuscaProduto()
	{
		lista = comando.BuscaProduto(produto.getNome());
	}

	

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List getLista() {
		return lista = comando.Listar_Dados();
	}

	public void setLista(List lista) {
		this.lista = lista;
	}
	
	
	
}
