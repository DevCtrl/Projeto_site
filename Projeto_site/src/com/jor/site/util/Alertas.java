
package com.jor.site.util;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
*
* @author Jorliano
*/
public class Alertas {
FacesContext context = FacesContext.getCurrentInstance();

	public void comfirmar(String msg) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Confirmado", msg));
	}

	public void errograve(String msg) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
				"Erro Grave ", msg));
	}

	public void erro(String msg) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Erro", msg));
	}

	public void errofatal(String msg) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
				"Erro fatal", msg));
	}


}
