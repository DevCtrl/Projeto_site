package com.jor.site.controle;

import java.util.ArrayList;
import java.util.List;

import com.jor.site.entidade.Produto;

public class tx {

	public static void main(String[] args) {
		 List<Produto> p = new ArrayList<Produto>();
		 VendaControler comando = new VendaControler();
	  
       
	  
	    comando.buscaVenda(1,"22/03/2015");
	 
	   
	  // System.out.println(p.get(0).getNome());
	}

}
