package com.jor.site.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.jor.site.controle.ClienteControler;
import com.jor.site.controle.EmpreendedorControler;
import com.jor.site.controle.ParceriaControler;
import com.jor.site.controle.ProdutoControler;
import com.jor.site.controle.UsuarioControler;
import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Empreendedor;
import com.jor.site.entidade.Parceria;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.Usuario;
import com.jor.site.util.Alerta;


@ManagedBean(name="benSistema")
@SessionScoped
public class SistemaBen {
    
	private String usuario;
	private String senha;	
	private  int quanteP = 0;
	private  int quanteC = 0;
	private  int quanteV = 0;
	private  int quanteE = 0;
	
	List<Cliente> listc = new ArrayList<Cliente>();
	List<Produto> listp = new ArrayList<Produto>();
	List<Parceria> listv = new ArrayList<Parceria>();
	List<Empreendedor> liste = new ArrayList<Empreendedor>();
	Usuario us = new Usuario();
	
	
	public SistemaBen()
	{
		listc = new ClienteControler().listarDados("Cliente");
		listp = new ProdutoControler().listarDados("Produto");
		listv = new ParceriaControler().listarDados("Parceria");
		liste = new EmpreendedorControler().listarDados("Empreendedor");
		
			quanteC = listc.size();
		    quanteP = listp.size();		
			quanteV = listv.size();		
            quanteE = liste.size();
	}			
	public String login()
	{
		
		
		us = (Usuario) new UsuarioControler().buscaUsuario(usuario);
		
	
		if(usuario.equals(us.getLogin()) && us.getLogin()!= null)
		{			
			if(senha.equals(us.getSenha()) && us.getSenha() != null)
			{
				System.out.println(us.getPrioridade());				
				return "sistema.xhtml";
			}
			Alerta.error("Senha incorreto");
		}
		Alerta.warn("Login incorreto");
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
	public Usuario getUs() {
		return us;
	}
	public void setUs(Usuario us) {
		this.us = us;
	}
	public int getQuanteV() {
		return quanteV;
	}
	public int getQuanteE() {
		return quanteE;
	}
    
	
    
	
		
	
	
	
}
