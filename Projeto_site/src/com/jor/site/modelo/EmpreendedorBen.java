




package com.jor.site.modelo;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.jor.site.controle.EmpreendedorControler;
import com.jor.site.entidade.Empreendedor;
import com.jor.site.util.Alerta;

@ManagedBean(name="benEmpreendedor")
@SessionScoped
public class EmpreendedorBen  {
   
	private Empreendedor empreendedor = new Empreendedor();
	Empreendedor empreendedorSelecionado;
	EmpreendedorControler comando = new EmpreendedorControler();	
	List lista = new ArrayList();
		
	public EmpreendedorBen()
	{
		lista =  comando.listarDados();			
	}
	
	
	public String  incluir()
	{
		
		if(empreendedor.getId() == 0){	
			empreendedorSelecionado = (Empreendedor) comando.buscaEmpreendedor(empreendedor.getNome());
			if(empreendedorSelecionado.getNome() == null){
				
				comando.inserir(empreendedor);
				lista = comando.listarDados();
				empreendedor = new Empreendedor();
			}
						
			else{
				Alerta.error("Empreendedor já existe");	
				return null;
			}
			
		}
		else{			
			comando.alterar(empreendedor);	
			lista = comando.listarDados();
			empreendedor = new Empreendedor();
		}		
		
		
		
		return "empreendedor.xhtml";
	}
	
	public String  edita()	{						
		return "configureempreendedor.xhtml";				
	}
	
	public String  cadastro(){
		empreendedor = new Empreendedor();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");       		
		empreendedor.setDataCadastro(sdf.format(new Date()));
		return "configureempreendedor.xhtml";					
	}
	public String deletar()
	{		
		comando.deletar(empreendedor);			
		lista = comando.listarDados();
		empreendedor = new Empreendedor();
		
		return "empreendedor.xhtml";
	}
	public String buscaEmpreendedor()
	{		
		lista = comando.buscaEmpreendedors(empreendedor.getNome());
		return "null";
	}

	public Empreendedor getempreendedor() {
		return empreendedor;
	}

	public void setempreendedor(Empreendedor empreendedor) {
		this.empreendedor = empreendedor;
	}

	public List getLista() {
		return lista ;
	}

	public void setLista(List lista) {
		this.lista = lista;
	}
	public Empreendedor getEmpreendedorSelecionado() {
		return empreendedorSelecionado;
	}
	public void setEmpreendedorSelecionado(Empreendedor empreendedorSelecionado) {
		this.empreendedorSelecionado = empreendedorSelecionado;
	}
	public Empreendedor getEmpreendedor() {
		return empreendedor;
	}
	public void setEmpreendedor(Empreendedor empreendedor) {
		this.empreendedor = empreendedor;
	}


	

		
}
