

import org.hibernate.Session;

import com.jor.site.controle.VendaControler;
import com.jor.site.util.HibernateUtil;

public class teste {
  public static void main(String[] args) {
	  System.out.println("teste");
	 VendaControler comand = new VendaControler();
	 comand.diminuirEstoque(1, 5);
}
}
