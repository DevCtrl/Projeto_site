package com.jor.site.controle;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Parceria;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class ParceriaControler {
  
	Session session;
	public void inserir(Parceria Parceria) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(Parceria);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{
			System.out.println("Erro ao Incluir Parceria "+er.getLocalizedMessage());
			Alerta.info("erro ao cadastra Parceria");
		}
		finally {	
			Alerta.info("Parceria "+Parceria.getNome()+" salvo com sucesso");
			session.close();
		}		
	}
	public void deletar(Parceria Parceria)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try{
			
			session.beginTransaction();
			session.delete(Parceria);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{			
			System.out.println("Erro ao Deletar Parceria "+er.getLocalizedMessage());
		}
		finally
		{
			Alerta.info("Parceria "+Parceria.getNome()+" deletado com sucesso");
			session.close();
		}
	}
	public void alterar(Parceria Parceria) {
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{		
			session.beginTransaction();			
			session.update(Parceria);			
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{
			System.out.println("Erro ao alterar Parceria "+er.getLocalizedMessage());
		}
		finally
		{
			Alerta.info("Parceria "+Parceria.getNome()+" alterado com sucesso");
			session.close();
		}
		
	}
	
	public List listarDados()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			
			Criteria cri = session.createCriteria(Parceria.class);
			return cri.list();
		}
		finally
		{
			session.close();
		}
	}
	public List buscaParcerias(String nome) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	        Query q = session.createQuery ("from Parceria where nome like '"+nome+"%'");
	        return q.list();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		return null;
	}		
	
	
	
}
