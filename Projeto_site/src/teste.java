

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;

import com.jor.site.controle.ClienteControler;
import com.jor.site.controle.EmpreendedorControler;
import com.jor.site.controle.ParceriaControler;
import com.jor.site.controle.ProdutoControler;
import com.jor.site.controle.RelatioControler;
import com.jor.site.controle.UsuarioControler;
import com.jor.site.controle.VendaControler;
import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Empreendedor;
import com.jor.site.entidade.Parceria;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.Usuario;
import com.jor.site.util.HibernateUtil;
@ManagedBean(name="teste")
@ViewScoped
public class teste {
	
	public static void main(String[] args) {  
	  
	   
		 VendaControler comando = new VendaControler();
	  
       
	    
	    
	  
	} 
	public void sobrecaregar(){
		for (int i = 101; i < 1000; i++) {
			Produto p = new Produto();
			p.setNome("produto"+i);
			p.setValor_Revenda(2.0);
			p.setValor_Varejo(3.0);
			p.setQuantidade(100);
			p.setDataCadastro("04/04/2015");
			new ProdutoControler().inserir(p);
			//cliente
			Cliente c = new Cliente();
			c.setNome("cliente"+i);
			c.setDataCadastro("04/04/2015");
			c.setEmail("jor@teste.com");
			new ClienteControler().inserir(c);
			//Empreendedor
			Empreendedor emp = new Empreendedor();
			emp.setNome("Empreendedor"+i);
			emp.setDataCadastro("04/04/2015");
			emp.setFlp("45454454");
			new EmpreendedorControler().inserir(emp);
			//vendedor
			Parceria pa = new Parceria();
			pa.setNome("vendedor"+i);
			pa.setFone("445555445");
			new ParceriaControler().inserir(pa);
			//usuario
			Usuario u = new Usuario();
			u.setNome("usuario"+i);
			u.setLogin("us");
			u.setSenha("us");
			u.setPrioridade("master");
			new UsuarioControler().inserir(u);
		}
	}
	
}
