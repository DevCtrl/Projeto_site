package com.jor.site.controle;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.ProdutoFornecido;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class ProdutoFornecidoControler extends Controler{
  Session session;	
	
	public List buscaProdutoFornecidos(String data,long id) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
	    	
	    	session.beginTransaction();
	        Query q = session.createQuery ("from ProdutoFornecido where dataCadastro = '"+data+"' and "
	        		                      + "id_parceria ='"+id+"'");
	        	       
	        List list = q.list();
	              
	        if(!list.isEmpty())
	         return list;	
	        else
	         return new ArrayList();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p "+e.getMessage());
	    }
		finally{
			 session.close();	
		}
		
			
		
		return null;
	}

			
	
}
