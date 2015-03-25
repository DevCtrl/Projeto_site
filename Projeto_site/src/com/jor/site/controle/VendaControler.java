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
	public List<Produto> buscaVenda(long l,String data) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			System.out.println("metodo chamado");	   	    	
	    	
	    	session.beginTransaction();
	        String sql ="from Produto where  id = any(from Venda"
	       	                       + " where id_cliente =:id and data=:data )";
	     
	       Query q = session.createQuery(sql); 	       
	       q.setParameter("data", data);
	       q.setParameter("id", l);
	       return  q.list();      
	       
	        
	      
	    
	      
	      
	 //  List<Produto> pro = new ArrayList<Produto>();
	 //  	 pro = q.list();
	 //   for (int i = 0; i < pro.size(); i++) {
	  //  	System.out.println(pro.get(i).getNome());
		//}
	   	 
		//return null;
	       
	        
	        
	        
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		finally{
			session.close();
		}
		return null;
	}
	
	
}
