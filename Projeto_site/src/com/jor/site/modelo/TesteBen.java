package com.jor.site.modelo;

import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
		// System.out.println(" teste");
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
		

	// 
	 // SimpleEmail email = new SimpleEmail();
	 // email.setHostName("smtp.googlegmail.com");
		// Email em =  new Email();
		// em.enviarEmail("jorliano@hotmail.com","gdasga");
	/*try {
		
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
		System.out.println("erro ao tentar enviar email");
		e.printStackTrace();
	}*/

	 
	  
		  Properties props = new Properties();
          /** Parâmetros de conexão com servidor Gmail */
          props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.socketFactory.port", "465");
          props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.port", "465");

          Session session = Session.getDefaultInstance(props,
                      new javax.mail.Authenticator() {
                           protected PasswordAuthentication getPasswordAuthentication()
                           {
                                 return new PasswordAuthentication("jorliano32@gmail.com", "leandrogmail");
                           }
                      });*/
          System.out.println("conectado ao email");
          /** Ativa Debug para sessão 
          session.setDebug(true);

          try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("jorliano32@gmail.com")); //Remetente

                Address[] toUser = InternetAddress //Destinatário(s)
                           .parse("jorliano@hotmail.com");  

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Comentario do site ");//Assunto
                message.setText("testando");
                /**Método para enviar a mensagem criada
                Transport.send(message);

               // Alerta.info("Dados enviado com sucesso");

           } catch (MessagingException e) {
                throw new RuntimeException(e);
          }*/

	 }
		
		
}
