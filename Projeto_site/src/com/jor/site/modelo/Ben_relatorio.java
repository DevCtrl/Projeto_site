package com.jor.site.modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;

@ManagedBean (name="ben1")
@ViewScoped	
public class Ben_relatorio {

	 private String nome ;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	 public void hand() {
	        nome = nome.toUpperCase();
	    }
	 
}
