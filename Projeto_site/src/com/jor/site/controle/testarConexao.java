package com.jor.site.controle;

import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.util.HibernateUtil;

public class testarConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Cliente cli = new Cliente();
        
        
		
		Control_cliente comando = new Control_cliente();
		cli = (Cliente) comando.BuscaCliente("novo");
		System.out.println("Cliente encontrado "+ cli.getNome());
	}

}
