package com.jor.site.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jor.site.controle.ContratoControler;
import com.jor.site.controle.ParceriaControler;
import com.jor.site.entidade.Contrato;
import com.jor.site.entidade.Parceria;
import com.jor.site.util.Alerta;

@ManagedBean(name="benParceria")
@SessionScoped
public class ParceriaBen {
  
	List listaParceria =  new ArrayList();
	List listaContratos =  new ArrayList();
	Parceria parceria = new Parceria();
	Contrato contrato = new Contrato();
	ParceriaControler comandoParceria = new ParceriaControler();
	ContratoControler comandoContrato = new ContratoControler();
	
	public ParceriaBen() {
		
		 listaParceria = comandoParceria.listarDados();
	}
	public void inserirParceria()
	{
		if(parceria.getId() == 0)		
		   comandoParceria.inserir(parceria);
		else
		   comandoParceria.alterar(parceria);
		
		
		parceria = new Parceria();
		listaParceria = comandoParceria.listarDados();
	}
	public String deletarParceria()
	{
		comandoParceria.deletar(parceria);
		parceria = new Parceria();
		listaParceria = comandoParceria.listarDados();
		return "parceria.xhtml";
	}
	public void buscaParceria(){
	    listaParceria = comandoParceria.buscaParcerias(parceria.getNome());
	}
	public String pagina(){
		return "parcerias.xhtml";
	}
	//Contrato
	
	public void inserirContrato()
	{
	  if(parceria.getId() != 0){
		if(contrato.getId() == 0)		
		   comandoContrato.inserir(contrato);
		else
		   comandoContrato.alterar(contrato);		
		contrato = new Contrato();
		
	  }
	  else{
		  Alerta.error("Selecione uma empresa");
	  }
	}
	public void deletarContrato()
	{
		comandoContrato.deletar(contrato);
		contrato = new Contrato();	
		
	}
	public void buscaContratoId(){
	    contrato = (Contrato) comandoContrato.buscaContrato(contrato.getId());
	}
}
