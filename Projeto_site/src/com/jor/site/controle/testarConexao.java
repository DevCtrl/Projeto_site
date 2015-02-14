package com.jor.site.controle;

import java.util.Date;

import javax.faces.event.ActionEvent;

import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.Venda;
import com.jor.site.util.HibernateUtil;

public class testarConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Cliente cli = new Cliente();
        Produto pd = new Produto();
        Venda vd = new Venda();
        Control_venda comandoVd = new Control_venda();
      
    	cli.setId(1);
    	pd.setId(1);
        
	 		vd.setCliente(cli);
    		vd.setProduto(pd);
    		vd.setData(new Date());
    		System.out.println("id produto "+vd.getProduto().getNome()+
    						           "\n id cliente "+vd.getCliente().getNome()+
    						           "\n data "+vd.getData());
    				comandoVd.inserir(vd);
    							
    			
    	
		
	}

}
