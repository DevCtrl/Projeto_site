package com.jor.site.controle;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Site;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class SiteControler {
  Session session;
  
    public void incluir(Site site)
    {
    	session =  HibernateUtil.getSessionFactory().openSession();
    	try
    	{
		    session.beginTransaction();
		    session.saveOrUpdate(site);
		    session.getTransaction().commit();
		    
		} catch (Exception e) {			
           Alerta.error("Erro ao tentar salvar primeiro conteudo");
		}
    	finally
    	{
    		Alerta.info("Dados salvos com sucesso");
    		session.close();
    	}
    }
    public Object buscaSite() {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();	    	
	         
	    	  Query q = session.createQuery("from Site where id = 1" );	    	  	    	     	            	         	    	  
	    	  if(q.uniqueResult() == null)  	        	   	        	
   	        	return new Site();   	             	          	  
   	          else 	  
	          return q.uniqueResult();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar "+e.getMessage());
	    }
		return null;
		
	}
}
