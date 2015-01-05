package com.jor.site.modelo;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import antlr.collections.List;

import com.jor.site.controle.Control_cliente;
import com.jor.site.entidade.Cliente;

@ManagedBean (name="ben_cli")
@ViewScoped
public class Ben_cliente {
   
	Cliente NovoCli = new Cliente();	
	Control_cliente comando = new Control_cliente();
	List lista;
	public Ben_cliente()
	{
	   	
	}
	
	public void salvar(ActionEvent evt)
	{
		
	}
	public void Editar(ActionEvent evt)
	{
		
	}
	public void Excluir(ActionEvent evt)
	{
		
	}
	public void Listar()
	{
		
	}
}
