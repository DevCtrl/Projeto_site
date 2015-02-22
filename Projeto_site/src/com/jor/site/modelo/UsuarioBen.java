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
	Usuario usuarioSelecionado = new Usuario();
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
		System.out.println("usario "+usuario.getNome());
		
		if(usuario.getId() == 0)
		comando.inserir(usuario);
		else
		comando.alterar(usuario);
		
		usuario = new Usuario();
		lista  = comando.listarDados();
		return "usuario.xhtml";
		
	}
	public String deletar()
	{
		comando.deletar(usuario);		
		lista = comando.listarDados();
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
		return lista = comando.listarDados();
	}

	public void setLista(List lista) {
		this.lista = lista;
	}
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}
	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	
	
}
