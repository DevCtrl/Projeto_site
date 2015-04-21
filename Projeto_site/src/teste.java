


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Produto;
import com.jor.site.util.Email;
import com.jor.site.util.HibernateUtil;

public class teste {
	static List<Produto> p = new ArrayList<Produto>(); 
	public static void main(String[] args) {  	
		
			
	 	
	     
		 /* SimpleEmail email = new SimpleEmail();
			
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
  */
		SimpleEmail email = new SimpleEmail();
		 email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
		 email.setSmtpPort(465);
		 try {
			email.addTo("jorliano@hotmail", "John Doe");
			 email.setFrom("jorliano32@gmail.com", "Me"); // remetente
			 email.setSubject("Mensagem de Teste"); // assunto do e-mail
			 email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail
			 email.send(); //envia o e-mail
			 
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //destinatário
	
	}	
	
}
