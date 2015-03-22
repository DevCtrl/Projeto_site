package com.jor.site.controle;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Empreendedor;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class EmpreendedorControler{
	private Session session;	
	
	public void inserir(Empreendedor empreendedor) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(empreendedor);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{
			System.out.println("Erro ao Incluir Empreendedor "+er.getLocalizedMessage());
			Alerta.info("erro ao cadastra Empreendedor");
		}
		finally {	
			Alerta.info("Empreendedor "+empreendedor.getNome()+" salvo com sucesso");
			session.close();
		}		
	}
	public void deletar(Empreendedor empreendedor)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try{
			
			session.beginTransaction();
			session.delete(empreendedor);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{			
			System.out.println("Erro ao Deletar Empreendedor "+er.getLocalizedMessage());
		}
		finally
		{
			Alerta.info("Empreendedor "+empreendedor.getNome()+" deletado com sucesso");
			session.close();
		}
	}
	public void alterar(Empreendedor empreendedor) {
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{		
			session.beginTransaction();			
			session.update(empreendedor);			
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{
			System.out.println("Erro ao alterar Empreendedor "+er.getLocalizedMessage());
		}
		finally
		{
			Alerta.info("Empreendedor "+empreendedor.getNome()+" alterado com sucesso");
			session.close();
		}
		
	}
	
	public List listarDados()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			
			Criteria cri = session.createCriteria(Empreendedor.class);
			return cri.list();
		}
		finally
		{
			session.close();
		}
	}
	public List buscaEmpreendedors(String nome) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	        Query q = session.createQuery ("from Empreendedor where nome like '"+nome+"%'");
	        return q.list();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		return null;
	}		
	
	public Object buscaEmpreendedor(String texto) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();	    	
	         
	    	  Query q = session.createQuery("from Empreendedor where nome = :name" );
	    	  q.setParameter("name", texto);	 	    	     	            	         	    	  
	    	  if(q.uniqueResult() == null)  	        	   	        	
   	        	return new Empreendedor();   	             	          	  
   	          else 	  
	          return q.uniqueResult();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar "+e.getMessage());
	    }
		return null;
		
	}
	
	
	
	
}
