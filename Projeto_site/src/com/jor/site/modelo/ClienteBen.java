package com.jor.site.modelo;


import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.jor.site.controle.ClienteControler;
import com.jor.site.entidade.Cliente;
import com.jor.site.util.Alerta;

@ManagedBean(name="benCliente")
@SessionScoped
public class ClienteBen {
   
	private Cliente cliente = new Cliente();
	Cliente clienteSelecionado;
	ClienteControler comando = new ClienteControler();	
	List lista = new ArrayList();
		
	public ClienteBen()
	{
		lista =  comando.listarDados();			
	}
	
	
	public String  incluir()
	{
		System.out.println("  teste te "+cliente.getId());
		if(cliente.getId() == 0){			
			comando.inserir(cliente);			
		}
		else{			
			comando.alterar(cliente);			
		}		
		lista = comando.listarDados();
		cliente = new Cliente();
		
		
		return "cliente.xhtml";
	}
	
	public String  edita()	{						
		return "configurecliente.xhtml";				
	}
	
	public String  cadastro()	{
		cliente = new Cliente();
		return "configurecliente.xhtml";					
	}
	public String deletar()
	{		
		comando.deletar(cliente);			
		lista = comando.listarDados();
		cliente = new Cliente();
		
		return "cliente.xhtml";
	}
	public String buscaCliente()
	{		
		lista = comando.buscaClientes(cliente.getNome());
		return "null";
	}

	public Cliente getcliente() {
		return cliente;
	}

	public void setcliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List getLista() {
		return lista ;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	

		
}
