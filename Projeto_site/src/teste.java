

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
	  
	   List<Produto> p = new ArrayList<Produto>();
		 VendaControler comando = new VendaControler();
	  
       
	  
	   //p = comando.buscaVenda();
	 
	   
	   System.out.println(p.get(0).getNome()+" teste");
	}  
	
}
