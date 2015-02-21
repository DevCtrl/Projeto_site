package com.jor.site.controle;

import java.util.List;










import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Usuario;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class Control_usuario {
	private Session session;

	public void inserir(Usuario usuario) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(usuario);
			session.getTransaction().commit();
		} finally {
			Alerta.info("Usuario "+usuario.getNome()+" cdastrado com sucesso");
			session.close();
		}
	}
	public void alterar(Usuario usuario) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(usuario);
			session.getTransaction().commit();
		} finally {
			Alerta.info("Usuario "+usuario.getNome()+" alterado com sucesso");
			session.close();
		}
	}
	public void deletar(Usuario usuario)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
		}
		finally
		{
			Alerta.info("Usuario Deletado");
			session.close();
		}
	}
	public Object BuscaUsuario(String texto) {
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
	public List Listar_Dados()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			
			Criteria cri = session.createCriteria(Usuario.class);
			return cri.list();
		}
		finally
		{
			session.close();
		}
	}
	
	
}
