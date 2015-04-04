package com.jor.site.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;

import com.jor.site.controle.RelatioControler;
import com.jor.site.entidade.Produto;
import com.jor.site.util.Alerta;

@ManagedBean (name="benRelatorio")
@RequestScoped
public class RelatorioBen {
   List<Produto> pro = new ArrayList<Produto>();
   private String nome1,nome2,nome3;
   private int valor1,valor2,valor3;
   private String titulo ="Nenhum Relatorio Selecionado";
   
   RelatioControler comando = new RelatioControler();
   private String grafico = "";
  public RelatorioBen(){
	  comando.relatorioCliente();
	  comando.relatorioProduto();
	  pro = comando.relatorioVenda();
	  
      if(!pro.isEmpty()){
    	 if(pro.size() == 1) {
		  nome1 = pro.get(0).getNome();
		  valor1 = pro.get(0).getQuantidade();
    	 }
    	 if(pro.size() == 2){
    		 nome1 = pro.get(0).getNome();
   		     valor1 = pro.get(0).getQuantidade();
   		     nome2 = pro.get(1).getNome();
		     valor2 = pro.get(1).getQuantidade();
    	 }
    	 if(pro.size() == 3){
    		 nome1 = pro.get(0).getNome();
   		     valor1 = pro.get(0).getQuantidade();
   		     nome2 = pro.get(1).getNome();
		     valor2 = pro.get(1).getQuantidade();
		     nome3 = pro.get(2).getNome();
			 valor3 = pro.get(2).getQuantidade();
    	 }
    	
		 
      }	
  }       
   
public void painel() {
	if(grafico.length() == 10)
		titulo="Grafico de Clientes Cadastrados";  	
	if(grafico.length() == 14)
		titulo="Graficos de Produtos Cadastrados";		
	if(grafico.length() == 12)
		titulo="Graficos de Produtos Mais Vendidos";
	
	
}  
   
public RelatioControler getComando() {
	return comando;
}
public void setComando(RelatioControler comando) {
	this.comando = comando;
}

public String getGrafico() {
	return grafico;
}

public void setGrafico(String grafico) {
	this.grafico = grafico;
}



public List<Produto> getPro() {
	return pro;
}



public void setPro(List<Produto> pro) {
	this.pro = pro;
}



public String getNome1() {
	return nome1;
}



public void setNome1(String nome1) {
	this.nome1 = nome1;
}



public String getNome2() {
	return nome2;
}



public void setNome2(String nome2) {
	this.nome2 = nome2;
}



public String getNome3() {
	return nome3;
}



public void setNome3(String nome3) {
	this.nome3 = nome3;
}



public int getValor1() {
	return valor1;
}



public void setValor1(int valor1) {
	this.valor1 = valor1;
}



public int getValor2() {
	return valor2;
}



public void setValor2(int valor2) {
	this.valor2 = valor2;
}



public int getValor3() {
	return valor3;
}



public void setValor3(int valor3) {
	this.valor3 = valor3;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}



	

	
	
	
	
	
}
