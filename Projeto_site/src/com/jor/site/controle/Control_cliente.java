package com.jor.site.controle;

import java.util.List;







import javax.faces.context.ExceptionHandler;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.omg.CORBA.ExceptionList;

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
		}
		finally {
			System.out.println("cliente cdastrado com sucesso");
			session.close();
		}
	}
	public void deletar(Cliente cliente)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.delete(cliente);
			session.getTransaction().commit();
		}
		finally
		{
			System.out.println("Cliente Deletado");
			session.close();
		}
	}
	public void alterar(Cliente cliente) {
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.saveOrUpdate(cliente);
			session.getTransaction();
		}finally
		{
			System.out.println("cliente alterado com sucesso");
			session.close();
		}
		
	}
	
	public List Listar_Dados()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			
			Criteria cri = session.createCriteria(Cliente.class);
			return cri.list();
		}
		finally
		{
			session.close();
		}
	}
	
	
}
