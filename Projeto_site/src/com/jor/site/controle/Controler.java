package com.jor.site.controle;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class Controler {
private Session session;	
	
	public void inserir(Object objeto,String msg) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(objeto);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{			
			Alerta.info("erro ao cadastra dados");
		}
		finally {	
			Alerta.info(msg);
			session.close();
		}		
	}
	public void deletar(Object objeto,String msg)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try{
			
			session.beginTransaction();
			session.delete(objeto);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{			
			Alerta.error("Erro ao deletar dados");
		}
		finally
		{
			Alerta.info(msg);
			session.close();
		}
	}
	public void alterar(Object objeto,String msg) {
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{		
			session.beginTransaction();			
			session.update(objeto);			
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{
			Alerta.error("Erro ao alerar dados");
		}
		finally
		{
			Alerta.info(msg);
			session.close();
		}
		
	}	
	public List listarDados(String tabela)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{			
			session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	        Query q = session.createQuery ("from "+tabela);
	       
	        return q.list();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		finally
		{
			session.close();
		}
		return null;
	}
	public List buscarListaPorNome(String tabela,String nome) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	        Query q = session.createQuery ("from "+tabela+" where nome like '"+nome+"%'");
	        return q.list();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		finally
		{
			session.close();
		}
		return null;
	}		
	
	public Object buscarClassePorId(String tabela,long id) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();	    	
	         
	    	  Query q = session.createQuery("from "+tabela+" where id = :id" );
	    	  q.setParameter("id", id);	 	    	     	            	         	    	  
	    	  if(q.uniqueResult() == null)  	        	   	        	
   	        	return new Object();   	             	          	  
   	          else 	  
	          return q.uniqueResult();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar "+e.getMessage());
	    }
		finally
		{
			session.close();
		}
		return null;		
	}
	public Object buscarClassePorNome(String tabela,String nome) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();	    	
	         
	    	  Query q = session.createQuery("from "+tabela+" where nome = :nome" );
	    	  q.setParameter("nome", nome);	     	     	            	         	    	  
	    	  	  
	          return q.uniqueResult();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar "+e.getMessage());
	    }
		finally
		{
			session.close();
		}
		return null;		
	}
}
