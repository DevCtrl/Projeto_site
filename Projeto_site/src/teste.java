


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Produto;
import com.jor.site.util.Email;
import com.jor.site.util.HibernateUtil;

public class teste {
	static List<Produto> p = new ArrayList<Produto>(); 
	public static void main(String[] args) {  	
		
			
	 	
	     
		Session session = HibernateUtil.getSessionFactory().openSession();
	   	session.beginTransaction();
		    	
			 Query q = session.createQuery ("from Produto   order by nome ");	  
			 q.setFirstResult(12);  
			 q.setMaxResults(12); 
			 p = q.list(); 
		    	    		
	    System.out.println("Quantidade de itens "+p.size());	   
			for (int i = 0; i < p.size(); i++) {
			  System.out.println(p.get(i).getNome());
			}
		
	
	}	
	
}
