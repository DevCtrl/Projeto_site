package com.jor.site.modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jor.site.util.Email;

@ManagedBean(name="benTeste")
@SessionScoped
public class TesteBen {
    
	public void sendEmail()  {
		Email rm = new Email();
		rm.enviarEmail("jorliano@hotmail.com", "teste pelo apache");

	 }
		
		
}
