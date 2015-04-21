package com.jor.site.util;


import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email
{
      public void enviarEmail(String destinatario,String menssage){
    	  
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
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("jorliano32@gmail.com")); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(destinatario);  

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Comentario do site ");//Assunto
                  message.setText(menssage);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

                  Alerta.info("Dados enviado com sucesso");

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      }
}

