package com.jor.site.controle;

import java.util.ArrayList;
import java.util.List;

import com.jor.site.entidade.Produto;

public class tx {

	public static void main(String[] args) {
		 List<Produto> p = new ArrayList<Produto>();
		 VendaControler comando = new VendaControler();
	  
       
	  
	    p = new RelatioControler().relatorioVenda();
	 
	   for (int i = 0; i < p.size(); i++) {
		System.out.println(p.get(i).getNome()+" "+p.get(i).getQuantidade());
	}
	  // System.out.println(p.get(0).getNome());
	}

}
