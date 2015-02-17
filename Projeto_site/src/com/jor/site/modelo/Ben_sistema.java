package com.jor.site.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jor.site.controle.Control_cliente;
import com.jor.site.controle.Control_produto;
import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Produto;


@ManagedBean(name="ben_Sistema")
@ViewScoped
public class Ben_sistema {
  
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
	
	
	
	
	public int getQuanteP() {
		return quanteP  ;
	}
	public int getQuanteC() {
		return quanteC;
	}

	
	
	
	
}
