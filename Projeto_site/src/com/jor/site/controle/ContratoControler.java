package com.jor.site.controle;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Contrato;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class ContratoControler {
  Session session;
  public void inserir(Contrato Contrato) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(Contrato);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{
			System.out.println("Erro ao Incluir Contrato "+er.getLocalizedMessage());
			Alerta.info("erro ao cadastra Contrato");
		}
		finally {	
			Alerta.info("Contrato "+Contrato.getNome()+" salvo com sucesso");
			session.close();
		}		
	}
	public void deletar(Contrato Contrato)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try{
			
			session.beginTransaction();
			session.delete(Contrato);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{			
			System.out.println("Erro ao Deletar Contrato "+er.getLocalizedMessage());
		}
		finally
		{
			Alerta.info("Contrato "+Contrato.getNome()+" deletado com sucesso");
			session.close();
		}
	}
	public void alterar(Contrato Contrato) {
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{		
			session.beginTransaction();			
			session.update(Contrato);			
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{
			System.out.println("Erro ao alterar Contrato "+er.getLocalizedMessage());
		}
		finally
		{
			Alerta.info("Contrato "+Contrato.getNome()+" alterado com sucesso");
			session.close();
		}
		
	}
	
	public List listarDados()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			
			Criteria cri = session.createCriteria(Contrato.class);
			return cri.list();
		}
		finally
		{
			session.close();
		}
	}
	public List buscaContratos(int id) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	        Query q = session.createQuery ("from Contrato where id_parceria = '"+id+"'");
	        return q.list();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		return null;
	}		
	
	public Object buscaContrato(int id) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();	    	
	         
	    	  Query q = session.createQuery("from Contrato where id = :id" );
	    	  q.setParameter("id", id);	 	    	     	            	         	    	  
	    	  if(q.uniqueResult() == null)  	        	   	        	
 	        	return new Contrato();   	             	          	  
 	          else 	  
	          return q.uniqueResult();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar "+e.getMessage());
	    }
		return null;
		
	}
	
}
