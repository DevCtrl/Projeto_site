package com.jor.site.controle;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class ClienteControler {
	private Session session;	
	
	public void inserir(Cliente cliente) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{
			System.out.println("Erro ao Incluir cliente "+er.getLocalizedMessage());
			Alerta.info("erro ao cadastra cliente");
		}
		finally {	
			Alerta.info("Cliente "+cliente.getNome()+" salvo com sucesso");
			session.close();
		}		
	}
	public void deletar(Cliente cliente)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try{
			
			session.beginTransaction();
			session.delete(cliente);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{			
			System.out.println("Erro ao Deletar cliente "+er.getLocalizedMessage());
		}
		finally
		{
			Alerta.info("Cliente "+cliente.getNome()+" deletado com sucesso");
			session.close();
		}
	}
	public void alterar(Cliente cliente) {
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{		
			session.beginTransaction();			
			session.update(cliente);			
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{
			System.out.println("Erro ao alterar cliente "+er.getLocalizedMessage());
		}
		finally
		{
			Alerta.info("Cliente "+cliente.getNome()+" alterado com sucesso");
			session.close();
		}
		
	}
	
	public List listarDados()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			
			Criteria cri = session.createCriteria(Cliente.class);
			return cri.list();
		}
		finally
		{
			session.close();
		}
	}
	public List buscaClientes(String nome) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	        Query q = session.createQuery ("from Cliente where nome like '"+nome+"%'");
	        return q.list();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		return null;
	}		
	
	public Object buscaCliente(String texto) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();	    	
	         
	    	  Query q = session.createQuery("from Cliente where nome = :name" );
	    	  q.setParameter("name", texto);	 	    	     	            	         	    	  
	    	  if(q.uniqueResult() == null)  	        	   	        	
   	        	return new Cliente();   	             	          	  
   	          else 	  
	          return q.uniqueResult();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar "+e.getMessage());
	    }
		return null;
		
	}
	
	
	
	
}
