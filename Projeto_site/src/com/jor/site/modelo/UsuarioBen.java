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

import com.jor.site.controle.UsuarioControler;
import com.jor.site.entidade.Usuario;

@ManagedBean(name="benUsuario")
@SessionScoped
public class UsuarioBen {
   
	Usuario usuario = new Usuario();	
	UsuarioControler comando = new UsuarioControler();
	List lista = new ArrayList();	
	
	public String incluir()
	{
		 
		usuario = new Usuario();		
		return "configureusuario.xhtml";
	}
	public String pgConfigure()
	{
		return "configureusuario.xhtml";
	}
	public String cadastrar()
	{
		
		
		if(usuario.getId() == 0){
		 comando.inserir(usuario,"Usuario "+usuario.getNome()+" salvo com sucesso");
		}
		else{
		comando.alterar(usuario,"Usuario "+usuario.getNome()+" alterado com sucesso");
		}
		usuario = new Usuario();
		lista  = comando.listarDados("Usuario");
		return "usuario.xhtml";
		
	}
	public String deletar()
	{
		comando.deletar(usuario,"Usuario "+usuario.getNome()+" deletado com sucesso");		
		lista = comando.listarDados("Usuario");
		usuario = new Usuario();
		return "usuario.xhtml";
	}

	public Usuario getusuario() {
		return usuario;
	}

	public void setusuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List getLista() {
		return lista = comando.listarDados("Usuario");
	}

	public void setLista(List lista) {
		this.lista = lista;
	}
	

	
	
}
