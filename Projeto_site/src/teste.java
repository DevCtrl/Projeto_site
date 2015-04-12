

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;

import org.hibernate.Session;

import com.jor.site.controle.ClienteControler;
import com.jor.site.controle.EmpreendedorControler;
import com.jor.site.controle.ParceriaControler;
import com.jor.site.controle.ProdutoControler;
import com.jor.site.controle.RelatioControler;
import com.jor.site.controle.SiteControler;
import com.jor.site.controle.UsuarioControler;
import com.jor.site.controle.VendaControler;
import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Empreendedor;
import com.jor.site.entidade.Parceria;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.Usuario;
import com.jor.site.util.HibernateUtil;

public class teste {
	
	public static void main(String[] args) throws IOException {  
	  String caminho = "WebContent/resources/bootstrap/imagens/newfoto.jpg";
	  String erro    = "/resources/bootstrap/imagens/texte2.jpg";
	 // File file = new File("WebContent/resources/bootstrap/imagens/site/bits.jpg");    
  	new SiteControler().salvarImagem("a", "b");
	} 
	
	
}
