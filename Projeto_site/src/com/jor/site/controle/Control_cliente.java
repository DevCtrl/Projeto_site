package com.jor.site.controle;

import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.util.HibernateUtil;

public class Control_cliente {
	private Session session;

	public void inserir(Cliente cliente) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
		} finally {
			System.out.println("cliente cdastrado com sucesso");
			session.close();
		}
	}
}
