package com.jor.site.controle;

import java.util.List;



















import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Produto;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class ProdutoControler extends Controler {
	private Session session;

	
	
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
