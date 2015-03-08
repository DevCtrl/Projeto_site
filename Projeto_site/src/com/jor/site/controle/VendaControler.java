package com.jor.site.controle;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
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
	
}
