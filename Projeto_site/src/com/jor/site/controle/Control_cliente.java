package com.jor.site.controle;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.util.Alertas;
import com.jor.site.util.HibernateUtil;

public class Control_cliente {
	private Session session;
	Alertas msg = new Alertas();
	 Cliente c = new Cliente();	        
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
		}
		finally {
			msg.comfirmar("Cliente "+cliente.getNome()+" Cadastrado com sucesso");
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
			System.out.println("Erro ao Deletarcliente "+er.getLocalizedMessage());
		}
		finally
		{
			msg.comfirmar("Cliente "+cliente.getNome()+" deletado com sucesso");
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
			msg.comfirmar("Alterações no cliente "+cliente.getNome()+" feitas com sucesso");
			session.close();
		}
		
	}
	
	public List Listar_Dados()
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
	public List BuscaClientes(String nome) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	        Query q = session.createQuery ("from Cliente where nome = '"+nome+"%'");
	        return q.list();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		return null;
	}		
	
	public Object BuscaCliente(String texto) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();	    	
	         
	    	  Query q = session.createQuery("from Cliente where nome = :name" );
	    	  q.setParameter("name", texto);    	 	    	  
   	           	     	        	               
	          return q.uniqueResult();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar "+e.getMessage());
	    }
		return null;
		
	}
	
	
}
