package com.jor.site.modelo;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import com.jor.site.controle.Control_produto;
import com.jor.site.entidade.Produto;

@ManagedBean(name="benProduto")
@ViewScoped
public class Ben_produto {
   
	Produto produto = new Produto();
	Control_produto comando = new Control_produto();
	List lista = new ArrayList();
	
	
	
	public void Incluir(ActionEvent evt)
	{
		System.out.println("metodo chamado salvar");
		comando.inserir(produto);
		lista = comando.Listar_Dados();
		produto = new Produto();
	}
	public void Editar()
	{
		lista = comando.Listar_Dados();
		  
		System.out.println("testando se mostar");			
		
	}
	public void Excluir(ActionEvent evt)
	{
		comando.deletar(produto);		
		lista = comando.Listar_Dados();
		produto = new Produto();
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
