package com.jor.site.controle;

import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.util.HibernateUtil;

public class testarConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Cliente cli = new Cliente();
        cli.setNome("leabd");
        cli.setCidade("caucaia");
		
		Control_cliente comando = new Control_cliente();
		comando.inserir(cli);
	}

}
