

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.jor.site.controle.RelatioControler;
import com.jor.site.controle.VendaControler;
import com.jor.site.entidade.Produto;
import com.jor.site.util.HibernateUtil;

public class teste {
	
	public static void main(String[] args) {  
	   RelatioControler c = new RelatioControler();
	   List<Produto> p = new ArrayList<Produto>();
		 VendaControler comando = new VendaControler();
	   Date data = new Date();	
	   DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
       
	  
	   p = comando.buscaVenda(3, "14/03/2015");
	 
	   
	   System.out.println(p.get(0).getNome());
	}  
	public void b(){
		
	}
}
