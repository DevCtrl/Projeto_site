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
	public Object buscaProduto(long id) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	        Query q = session.createQuery ("from Produto where id =:id");
	        q.setParameter("id", id);
	        if(q.uniqueResult() == null){
	        	Produto pd = new Produto();
	        	return pd;
	        }
	        return q.uniqueResult();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		return null;
	}
	public Object buscaProdutoNome(String nome) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	        Query q = session.createQuery ("from Produto where nome =:nome");
	        q.setParameter("nome", nome);
	        if(q.uniqueResult() == null){
	        	Produto pd = new Produto();
	        	return pd;
	        }
	        return q.uniqueResult();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		return null;
	}
	
	public List buscaProdutoPor(String categoria,String ordenar,String ordenarTipo,double min,double max,int pagina) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	    	
	    	if(ordenar == "" || ordenar == null)
	    		ordenar = "nome";
	    	if(max < 1)
	    		max = 1000000;
	    	if(ordenarTipo == null)
	    		ordenarTipo = "asc";
	    	
	    	Query q;
			if(categoria != "" && categoria != null){
	           q = session.createQuery ("from Produto where categoria = '"+categoria+"' and "
	        	        	+ "valor_Revenda > "+min+" and valor_Revenda < "+max+" order by "+ordenar+" "+ordenarTipo);
	    	}
	    	else{
	    		 q = session.createQuery ("from Produto where valor_Revenda > "+min+" and valor_Revenda < "+max+" order by "+ordenar+" "+ordenarTipo );	    	     
	    	}
			 q.setFirstResult(pagina);  
			 q.setMaxResults(12); 	
	          return q.list();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		return null;
	}
	
	
	
	
}
