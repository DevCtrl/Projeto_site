package com.jor.site.modelo;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		lista =  comando.listarDados("Cliente");			
	}
	
	
	public String  incluir()
	{
		
		if(cliente.getId() == 0){	
			clienteSelecionado = (Cliente) comando.buscarClassePorNome("Cliente", cliente.getNome());
			if(clienteSelecionado == null){
				clienteSelecionado = new Cliente();
			}
			if(clienteSelecionado.getNome() == null){
				
				comando.inserir(cliente, "Cliente "+cliente.getNome()+" slavo com sucesso");
				lista = comando.listarDados("Cliente");
				cliente = new Cliente();
			}
						
			else{
				Alerta.error("Cliente já existe");	
				return null;
			}
			
		}
		else{			
			comando.alterar(cliente,"Cliente "+cliente.getNome()+" alterado com sucesso");	
			lista = comando.listarDados("Cliente");
			cliente = new Cliente();
		}		
		
		
		
		return "cliente.xhtml";
	}
	
	public String  edita()	{						
		return "configurecliente.xhtml";				
	}
	
	public String  cadastro(){
		cliente = new Cliente();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");       		
		cliente.setDataCadastro(sdf.format(new Date()));
		return "configurecliente.xhtml";					
	}
	public String deletar()
	{		
		comando.deletar(cliente,"Cliente "+cliente.getNome()+" Deletado com sucesso");			
		lista = comando.listarDados("Cliente");
		cliente = new Cliente();
		
		return "cliente.xhtml";
	}
	public String buscaCliente()
	{		
		lista = comando.buscarListaPorNome("Cliente",cliente.getNome());
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
