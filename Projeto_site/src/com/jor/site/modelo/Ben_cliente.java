package com.jor.site.modelo;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import com.jor.site.controle.Control_cliente;
import com.jor.site.entidade.Cliente;

@ManagedBean(name="benCliente")
@ViewScoped
public class Ben_cliente {
   
	Cliente cliente = new Cliente();
	Cliente clienteSelecionado = new Cliente();
	Control_cliente comando = new Control_cliente();
	List lista = new ArrayList();
	
	
	
	public void Incluir(ActionEvent evt)
	{
		System.out.println("metodo chamado salvar");
		comando.inserir(cliente);
		lista = comando.Listar_Dados();
		cliente = new Cliente();
	}
	public void Editar()
	{
		lista = comando.Listar_Dados();
		  
		System.out.println("testando se mostar");			
		
	}
	public void Excluir(ActionEvent evt)
	{
		comando.deletar(cliente);		
		lista = comando.Listar_Dados();
		cliente = new Cliente();
	}

	public Cliente getcliente() {
		return cliente;
	}

	public void setcliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List getLista() {
		return lista = comando.Listar_Dados();
	}

	public void setLista(List lista) {
		this.lista = lista;
	}
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}
	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	
	
}
