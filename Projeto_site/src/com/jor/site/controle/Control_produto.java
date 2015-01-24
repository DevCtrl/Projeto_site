package com.jor.site.controle;

import java.util.List;








import org.hibernate.Criteria;
import org.hibernate.Session;
import com.jor.site.entidade.Produto;
import com.jor.site.util.HibernateUtil;

public class Control_produto {
	private Session session;

	public void inserir(Produto produto) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(produto);
			session.getTransaction().commit();
		} finally {
			System.out.println("Produto cdastrado com sucesso");
			session.close();
		}
	}
	public void deletar(Produto produto)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.delete(produto);
			session.getTransaction().commit();
		}
		finally
		{
			System.out.println("Produto Deletado");
			session.close();
		}
	}
	
	public List Listar_Dados()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			
			Criteria cri = session.createCriteria(Produto.class);
			return cri.list();
		}
		finally
		{
			session.close();
		}
	}
	
}
