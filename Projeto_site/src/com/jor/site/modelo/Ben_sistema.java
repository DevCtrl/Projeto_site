package com.jor.site.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jor.site.controle.Control_cliente;
import com.jor.site.controle.Control_produto;
import com.jor.site.controle.Control_usuario;
import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.Usuario;


@ManagedBean(name="benSistema")
@ViewScoped
public class Ben_sistema {
    
	private String usuario;
	private String senha;
	private  int quanteP = 0;
	private  int quanteC = 0;
	
	List<Cliente> listc = new ArrayList<Cliente>();
	List<Produto> listp = new ArrayList<Produto>();
	
	
	public Ben_sistema()
	{
		listc = new Control_cliente().Listar_Dados();
		listp = new Control_produto().Listar_Dados();
		for (Cliente cliente : listc) 
			quanteC ++;
		for (Produto produto : listp) 
			quanteP ++;
				
	}			
	
	public String login()
	{
		
		Usuario us = new Usuario();
		us = (Usuario) new Control_usuario().BuscaUsuario(usuario);
		
	
		if(usuario.equals(us.getLogin()) && us.getLogin()!= null)
		{			
			if(senha.equals(us.getSenha()) && us.getSenha() != null)
			{
				
				return "Layout_Sistema.xhtml";
			}
		}
		return null;
	}
	
	
	public int getQuanteP() {
		return quanteP  ;
	}
	public int getQuanteC() {
		return quanteC;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
    
	
	
	
	
}
