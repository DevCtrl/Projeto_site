package com.jor.site.controle;

import java.util.List;










import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Usuario;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class UsuarioControler extends Controler{
	private Session session;
	
	public Object buscaUsuario(String texto) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();	    	
	         
	    	  Query q = session.createQuery("from Usuario where login = :login" );
	    	  q.setParameter("login", texto);	 	    	     	            	         	    	  
	    	  if(q.uniqueResult() == null)  	        	   	        	
   	        	return new Usuario();   	             	          	  
   	          else 	  
	          return q.uniqueResult();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar "+e.getMessage());
	    }
		return null;
		
	}
	
	
	
}
