package com.jor.site.controle;

import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Venda;
import com.jor.site.util.HibernateUtil;

public class Control_venda {

	public void inserir(Venda venda) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(venda);
			session.getTransaction().commit();
		}
		finally {
			System.out.println("venda cdastrado com sucesso");
			session.close();
		}
	}
}