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
   
	Cliente NovoCli = new Cliente();	
	Control_cliente comando = new Control_cliente();
	List lista = new ArrayList();
	
	
	
	public void salvar(ActionEvent evt)
	{
		
	}
	public void editar(ActionEvent evt)
	{
		System.out.println("testando se mostar");
		NovoCli.setNome("jorliano olivericdfsdfrsd");
		NovoCli.setCidade("cidade");
		
		comando.inserir(NovoCli);
	}
	public void Excluir(ActionEvent evt)
	{
		
	}

	public Cliente getNovoCli() {
		return NovoCli;
	}

	public void setNovoCli(Cliente novoCli) {
		NovoCli = novoCli;
	}

	public List getLista() {
		return lista;
	}

	public void setLista(List lista) {
		this.lista = lista;
	}
	
}
