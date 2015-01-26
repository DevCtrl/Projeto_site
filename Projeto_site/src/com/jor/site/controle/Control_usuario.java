package com.jor.site.controle;

import java.util.List;








import org.hibernate.Criteria;
import org.hibernate.Session;
import com.jor.site.entidade.Usuario;
import com.jor.site.util.HibernateUtil;

public class Control_usuario {
	private Session session;

	public void inserir(Usuario usuario) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(usuario);
			session.getTransaction().commit();
		} finally {
			System.out.println("Usuario cdastrado com sucesso");
			session.close();
		}
	}
	public void deletar(Usuario usuario)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
		}
		finally
		{
			System.out.println("Usuario Deletado");
			session.close();
		}
	}
	
	public List Listar_Dados()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			
			Criteria cri = session.createCriteria(Usuario.class);
			return cri.list();
		}
		finally
		{
			session.close();
		}
	}
	
}
