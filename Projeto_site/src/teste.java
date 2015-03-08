

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;

import com.jor.site.controle.RelatioControler;
import com.jor.site.controle.VendaControler;
import com.jor.site.util.HibernateUtil;

public class teste {
	public static void main(String[] args) {  
	   RelatioControler c = new RelatioControler();
	   
	   c.relatorioProduto();	   
	   System.out.println("mes de março "+c.getMarco());
	   System.out.println("mes de agosto "+c.getJaneiro());
	   c.relatorioCliente();
	   System.out.println("mes de outubro "+c.getJaneiro());
	}  
}
