package com.jor.site.controle;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Contrato;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class ContratoControler extends Controler{
  Session session;
  
	
	public List buscaContratos(long l) {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	        Query q = session.createQuery ("from Contrato where id_parceria = '"+l+"'");
	        return q.list();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar p"+e.getMessage());
	    }
		return null;
	}		
	
	
	
}
