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
	List listaContrato =  new ArrayList();
	Parceria parceria = new Parceria();
	Contrato contrato = new Contrato();
	ParceriaControler comandoParceria = new ParceriaControler();
	ContratoControler comandoContrato = new ContratoControler();
	
	public ParceriaBen() {
		
		 listaParceria = comandoParceria.listarDados();
	}
	public void inserirParceria()
	{
		if(parceria.getId() == 0){		
		   comandoParceria.inserir(parceria);
		   parceria = new Parceria();
		} 
		else
		   comandoParceria.alterar(parceria);				
		
		listaParceria = comandoParceria.listarDados();
	}
	public void deletarParceria()
	{
		comandoParceria.deletar(parceria);		
		listaParceria = comandoParceria.listarDados();
		
	}
	public void buscaParceria(){		
	    listaParceria = comandoParceria.buscaParcerias(parceria.getNome());
	}
	public String pagina(){
		return "parcerias.xhtml";
	}
	public void limparCampos(){
		parceria = new Parceria();
		contrato = new Contrato();
		listaContrato.clear();
	}
	//Contrato
	
	public void inserirContrato()
	{
	  if(parceria.getId() != 0){
		if(contrato.getId() == 0){
			System.out.println(parceria.getId());
			 contrato.setParceria(parceria);
			 comandoContrato.inserir(contrato);
		}
		  
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
	
	
	public List getListaParceria() {
		return listaParceria;
	}
	public void setListaParceria(List listaParceria) {
		this.listaParceria = listaParceria;
	}
	public List getlistaContrato() {
		if(parceria.getId() != 0)
			listaContrato = comandoContrato.buscaContratos(parceria.getId());
		else
			listaContrato.clear();
		return listaContrato;
	}
	public void setlistaContrato(List listaContrato) {
		this.listaContrato = listaContrato;
	}
	public Parceria getParceria() {
		return parceria;
	}
	public void setParceria(Parceria parceria) {
		this.parceria = parceria;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
}
