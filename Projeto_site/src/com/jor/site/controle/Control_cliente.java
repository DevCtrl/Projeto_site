package com.jor.site.controle;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import com.jor.site.entidade.Cliente;
import com.jor.site.util.HibernateUtil;

public class Control_cliente {
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
		}
		finally {
			System.out.println("cliente cdastrado com sucesso");
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
			System.out.println("Cliente Deletado "+cliente.getNome());
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
			System.out.println("cliente alterado com sucesso");
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
	public String BuscaCliente(String nome) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();	    	
	        Query q = session.createQuery ("from Cliente  where nome = '"+nome+"'");
	        System.out.println(q);
	        return (String) q.uniqueResult();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }		
		
		return null;
	}
	
	
}
