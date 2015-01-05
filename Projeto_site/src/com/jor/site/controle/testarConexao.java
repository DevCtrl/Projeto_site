package com.jor.site.controle;

import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.util.HibernateUtil;

public class testarConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Cliente cli = new Cliente();
        cli.setNome("leandro");
        cli.setCidade("caucaia");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(cli);
		session.getTransaction().commit();
	}

}
