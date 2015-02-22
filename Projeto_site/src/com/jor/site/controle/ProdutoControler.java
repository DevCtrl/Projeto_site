package com.jor.site.controle;

import java.util.List;

















import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Produto;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class ProdutoControler {
	private Session session;

	public void inserir(Produto produto) {		
		session = HibernateUtil.getSessionFactory().openSession();
	try {			
			session.beginTransaction();
			session.save(produto);
			session.getTransaction().commit();
		}
	catch(ExceptionInInitializerError er)
	{
		System.out.println("Erro ao Incluir Produto "+er.getLocalizedMessage());
	}
	finally {
		Alerta.info("Produto "+produto.getNome()+" cadastrado com sucesso");
			session.close();
		}
	}
	public void alterar(Produto produto) {		
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			
			session.beginTransaction();
			session.update(produto);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{
			System.out.println("Erro ao alterar produto "+er.getLocalizedMessage());
		}
		finally {
			Alerta.info("Produto "+produto.getNome()+" alterado com sucesso");
			session.close();
		}
		
	}
	public void deletar(Produto produto)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try{			
			session.beginTransaction();
			session.delete(produto);
			session.getTransaction().commit();
		}
		catch(ExceptionInInitializerError er)
		{
			System.out.println("Erro ao deletar produto"+er.getLocalizedMessage());
		}
		finally
		{
			Alerta.info("Produto Deletado");
			session.close();
		}
	}
	
	public List listarDados()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			
			Criteria cri = session.createCriteria(Produto.class);
			return cri.list();
		}
		finally
		{
			session.close();
		}
	}
	
	public List buscaProdutos(String nome) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	        Query q = session.createQuery ("from Produto where nome like '"+nome+"%'");
	        return q.list();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		return null;
	}
	
	
}
