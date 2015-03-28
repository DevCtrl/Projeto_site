package com.jor.site.controle;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.Venda;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class VendaControler {

	public void inserir(Venda venda) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(venda);
			session.getTransaction().commit();
		}
		finally {			
			session.close();
		}
	}
	public void diminuirEstoque(long id,int quantidade) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			  String hql = "update Produto set quantidade = quantidade -:quantidade where id = :id";
			  Query query = session.createQuery(hql);
			  query.setParameter("quantidade", quantidade);
			  query.setParameter("id", id);
			  query.executeUpdate();
			 session.getTransaction().commit(); 
			 System.out.println("alteração feita com sucesso");
		}
		finally {			
			session.close();
		}
	}
    public void troca(String nome, Integer quantidade, String nome2,Integer quantidade2) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			 //aumentar quantidade do produto no banco 
			  String hql = "update Produto set quantidade = quantidade +:quantidade where nome = :nome";
			  Query query = session.createQuery(hql);
			  query.setParameter("quantidade", quantidade);
			  query.setParameter("nome", nome);
			  query.executeUpdate();
			//diminuir quantidade do produto no banco   
			  String hql2 = "update Produto set quantidade = quantidade -:quantidade where id = :id";
			  Query query2 = session.createQuery(hql2);
			  query.setParameter("quantidade", quantidade2);
			  query.setParameter("nome", nome2);
			  query.executeUpdate();
			  
			 session.getTransaction().commit(); 
			 System.out.println("troca feita com sucesso");
		}
		finally {			
			session.close();
		}
		
	}
	public List<Produto> buscaVenda(long l,String data) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			System.out.println("metodo chamado");	   	    	
	    	
	    	session.beginTransaction();
	           
	    	List<Produto> pro = new ArrayList<Produto>(); 
	    	Query q = session.createQuery("from Venda where id_cliente =:id and data=:data "); 
	    	q.setParameter("data", data);
		    q.setParameter("id", l);
		    List<Venda> v = new ArrayList<Venda>();
		    v = q.list();
	        for(int i=0;i<v.size();i++){
	        	Query h = session.createQuery("from Produto where id = "+v.get(i).getProduto().getId()); 
	        	Produto p = new Produto();
	        	p=(Produto) h.uniqueResult();
	        	int quant = (int) (v.get(i).getComprado()/p.getValor_Revenda());
	        	p.setQuantidade(quant);
	        	p.setComprado(v.get(i).getComprado());
	        	pro.add(p);
	        }      
	
	   	 
		return pro;   	        	        
		
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		finally{
			session.close();
		}
		return null;
	}
	
	
}
