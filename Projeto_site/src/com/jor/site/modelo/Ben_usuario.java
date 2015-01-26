package com.jor.site.modelo;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import com.jor.site.controle.Control_usuario;
import com.jor.site.entidade.Usuario;

@ManagedBean(name="benUsuario")
@RequestScoped
public class Ben_usuario {
   
	Usuario usuario = new Usuario();
	Usuario usuarioSelecionado = new Usuario();
	Control_usuario comando = new Control_usuario();
	List lista = new ArrayList();
	
	
	
	public String Incluir()
	{
		return "ConfigureUsuario.xhtml";
	}
	public void Cadastrar(ActionEvent evt)
	{
		comando.inserir(usuario);			
		
	}
	public void Excluir(ActionEvent evt)
	{
		comando.deletar(usuario);		
		lista = comando.Listar_Dados();
		usuario = new Usuario();
	}

	public Usuario getusuario() {
		return usuario;
	}

	public void setusuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List getLista() {
		return lista = comando.Listar_Dados();
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
