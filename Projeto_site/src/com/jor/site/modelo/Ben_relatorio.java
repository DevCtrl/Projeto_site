package com.jor.site.modelo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;

import com.jor.site.util.Alertas;

@ManagedBean (name="ben1")
@SessionScoped
public class Ben_relatorio {

	 private String nome ;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public void saveMessage(ActionEvent evt) {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Your message: eu sou o cara " ) );
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
    }
	
}
