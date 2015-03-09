package com.jor.site.modelo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;

import com.jor.site.controle.RelatioControler;
import com.jor.site.util.Alerta;

@ManagedBean (name="benRelatorio")
@RequestScoped
public class RelatorioBen {
   RelatioControler comando = new RelatioControler();
   private String grafico = "";
  public RelatorioBen(){
	  comando.relatorioCliente();
	  comando.relatorioProduto();
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
	

	
	
	
	
	
}
