package com.jor.site.modelo;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import com.jor.site.controle.Control_cliente;
import com.jor.site.entidade.Cliente;

@ManagedBean(name="benCliente")
@ViewScoped
public class Ben_cliente {
   
	Cliente cliente = new Cliente();	
	Control_cliente comando = new Control_cliente();
	List lista = new ArrayList();
	
	
	
	public void Incluir(ActionEvent evt)
	{
		System.out.println("metodo chamado");
		comando.inserir(cliente);
		lista = comando.Listar_Dados();
	}
	public void Editar(ActionEvent evt)
	{
		System.out.println("testando se mostar");			
		
	}
	public void Excluir(ActionEvent evt)
	{
		
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

	
	
}
