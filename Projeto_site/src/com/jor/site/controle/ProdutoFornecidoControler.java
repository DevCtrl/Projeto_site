package com.jor.site.controle;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.ProdutoFornecido;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class ProdutoFornecidoControler {
  Session session;
  public void inserir(ProdutoFornecido ProdutoFornecido) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(ProdutoFornecido);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{
			System.out.println("Erro ao Incluir ProdutoFornecido "+er.getLocalizedMessage());
			Alerta.info("erro ao cadastra ProdutoFornecido");
		}
		finally {	
			Alerta.info("ProdutoFornecido "+ProdutoFornecido.getNome()+" adicionado");
			session.close();
		}		
	}
	public void deletar(ProdutoFornecido ProdutoFornecido)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try{			
			session.beginTransaction();
			session.delete(ProdutoFornecido);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{			
			System.out.println("Erro ao Deletar ProdutoFornecido "+er.getLocalizedMessage());
		}
		finally
		{
			Alerta.info("ProdutoFornecido "+ProdutoFornecido.getNome()+" deletado com sucesso");
			session.close();
		}
	}
	
	
	
	public List buscaProdutoFornecidos(String data,int id) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
	    	
	    	session.beginTransaction();
	        Query q = session.createQuery ("from ProdutoFornecido where dataCadastro = '"+data+"' and "
	        		                      + "id_parceria ='"+id+"'");
	        	       
	        return q.list();
	        
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p "+e.getMessage());
	    }
		finally{
			session.close();
		}
		return null;
	}	
	
}
