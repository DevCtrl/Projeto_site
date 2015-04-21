package com.jor.site.modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.jor.site.util.Email;

@ManagedBean(name="benTeste")
@RequestScoped
public class TesteBen {
    
	public void enviar()  {
		// String conteudo ="Nome :"+ nomeMenssage+"    Telefone :"+telefoneMenssage+"\n"+
	                    //  "Objetivo : "+objetivoMenssage+"\n"+conteudoMenssage;
		// Alerta.info(conteudo);
		 System.out.println(" teste");
		 //Email em =  new Email();
		// em.enviarEmail("jorliano@hotmail.com",conteudo);
	// SimpleEmail email = new SimpleEmail();
		
	//	 try {
	//		 email.setHostName("mail.myserver.com"); // o servidor SMTP para envio do e-mail
	//		 email.addTo("jorliano@hotmail", "John Doe");
	//		 email.setFrom("jorliano32@gmail.com", "Me"); // remetente
	//		 email.setSubject("Mensagem de Teste"); // assunto do e-mail
	//		 email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail
	//		 email.send(); //envia o e-mail
	//		 
	//	} catch (EmailException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	} //destinatário
		

	 
	  SimpleEmail email = new SimpleEmail();
	
	try {
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("jorliano32@gmail.com", "leandrogmail"));
		email.setSSLOnConnect(true);
		email.setFrom("jorliano32@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("jorliano@hotmail.com");
		email.send();
	} catch (EmailException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 
	  
		 

	 }
		
		
}
