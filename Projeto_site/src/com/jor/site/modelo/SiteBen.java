package com.jor.site.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;










import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.jor.site.controle.ProdutoControler;
import com.jor.site.controle.SiteControler;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.Site;
import com.jor.site.util.Alerta;
import com.jor.site.util.Email;
import com.jor.site.util.Validar;

@ManagedBean(name="benSite")
@SessionScoped
public class SiteBen {
   
	Site site = new Site();
    SiteControler comando = new SiteControler();
    String caminho;
    //email
    private String nomeMenssage;
    private String emailMenssage;
    private String conteudoMenssage;
    private String telefoneMenssage;
    private String objetivoMenssage;
    //pesquisar
    private String ordenar;
    private String categoria;
    private String ordenarTipo;
    private double priceMin = 0.0;
    private double priceMax;
    private int paginaAtual=0;
    private int paginaAnterio=0;
    //constantes    
    private String imagem;
    private String titulo;
    private String conteudo;
    private String video;
    private Part foto;
    //
    Produto p = new Produto();
    List listaProduto = new ArrayList();
    
    Validar util = new Validar();
    public SiteBen(){
    	site = (Site) comando.buscaSite();     
    	listaProduto = new ProdutoControler().listarDados();
    }  
    @PostConstruct
    public void load(){
    	site = (Site) comando.buscaSite();
    	
    }
	
    public String criarImagem1(){
    	if(foto != null)
    	util.Upload(foto,"trabalhos/negocio1.jpg");
    	site.setUrlImagem1("/resources/bootstrap/imagens/site/trabalhos/negocio1.jpg");    	
    	Alerta.warn(site.getTitulo1());
    	comando.incluir(site);
    	return null;
    }
    public String criarImagem2(){
    	if(foto != null)
    	util.Upload(foto,"trabalhos/negocio2.jpg");
    	site.setUrlImagem2("/resources/bootstrap/imagens/site/trabalhos/negocio2.jpg");
    	comando.incluir(site);
    	return null;
    }
    public String criarImagem3(){
    	if(foto != null)
    	util.Upload(foto,"trabalhos/negocio3.jpg");
    	site.setUrlImagem3("/resources/bootstrap/imagens/site/trabalhos/negocio3.jpg");
    	comando.incluir(site);
    	return null;
    }  
    public String criarImagem4(){
    	if(foto != null)
    	util.Upload(foto,"trabalhos/negocio4.jpg");
    	site.setUrlImagem4("/resources/bootstrap/imagens/site/trabalhos/negocio4.jpg");
    	comando.incluir(site);
    	return null;
    }  
    public String criarImagem5(){
    	if(foto != null)
    	util.Upload(foto,"trabalhos/negocio5.jpg");
    	site.setUrlImagem5("/resources/bootstrap/imagens/site/trabalhos/negocio5.jpg");
    	comando.incluir(site);
    	return null;
    }  
    public String criarImagem6(){
    	if(foto != null)
    	util.Upload(foto,"trabalhos/negocio6.jpg");
    	site.setUrlImagem6("/resources/bootstrap/imagens/site/trabalhos/negocio6.jpg");
    	comando.incluir(site);
    	return null;
    }  
    public String criarImagem7(){
    	if(foto != null)
    	util.Upload(foto,"trabalhos/negocio7.jpg");
    	site.setUrlImagem7("/resources/bootstrap/imagens/site/trabalhos/negocio7.jpg");
    	comando.incluir(site);
    	return null;
    }  
    public String criarImagem8(){
    	if(foto != null)
    	util.Upload(foto,"trabalhos/negocio8.jpg");
    	site.setUrlImagem8("/resources/bootstrap/imagens/site/trabalhos/negocio8.jpg");
    	comando.incluir(site);
    	return null;
    }  
    
    
   public String trabalho1(){
	   imagem = site.getUrlImagem1();
	   titulo = site.getTitulo1();
	   conteudo = site.getConteudo1();
	   video = site.getVideo1();
	   return "conteudo.xhtml";
   }
   public String trabalho2(){
	   imagem = site.getUrlImagem2();
	   titulo = site.getTitulo2();
	   conteudo = site.getConteudo2();
	   video = site.getVideo2();
	   return "conteudo.xhtml";
   }
   public String trabalho3(){
	   imagem = site.getUrlImagem3();
	   titulo = site.getTitulo3();
	   conteudo = site.getConteudo3();
	   video = site.getVideo3();
	   return "conteudo.xhtml";
   }
   public String trabalho4(){
	   imagem = site.getUrlImagem4();
	   titulo = site.getTitulo4();
	   conteudo = site.getConteudo4();
	   video = site.getVideo4();
	   return "conteudo.xhtml";
   }
   public String trabalho5(){
	   imagem = site.getUrlImagem5();
	   titulo = site.getTitulo5();
	   conteudo = site.getConteudo5();
	   video = site.getVideo5();
	   return "conteudo.xhtml";
   }
   public String trabalho6(){
	   imagem = site.getUrlImagem6();
	   titulo = site.getTitulo6();
	   conteudo = site.getConteudo6();
	   video = site.getVideo6();
	   return "conteudo.xhtml";
   }
   public String trabalho7(){
	   imagem = site.getUrlImagem7();
	   titulo = site.getTitulo7();
	   conteudo = site.getConteudo7();
	   video = site.getVideo7();
	   return "conteudo.xhtml";
   }
   public String trabalho8(){
	   imagem = site.getUrlImagem8();
	   titulo = site.getTitulo8();
	   conteudo = site.getConteudo8();
	   video = site.getVideo8();
	   return "conteudo.xhtml";
   }
   public String slide1(){
   	if(foto != null)
   	util.Upload(foto,"slide/slide1.jpg");    	
   	return null;
   } 
   public String slide2(){
	   	if(foto != null)
	   	util.Upload(foto,"slide/slide2.jpg");    	
	   	return null;
   } 
   public String slide3(){
	   	if(foto != null)
	   	util.Upload(foto,"slide/slide3.jpg");    	
	   	return null;
  } 

 public void enviar()  {
	 String conteudo ="Nome :"+ nomeMenssage+"    Telefone :"+telefoneMenssage+"\n"+
                      "Objetivo : "+objetivoMenssage+"\n"+conteudoMenssage;
	// Alerta.info(conteudo);
	
	 //Email em =  new Email();
	// em.enviarEmail("jorliano@hotmail.com",conteudo);
	
	

  SimpleEmail email = new SimpleEmail();
	email.setHostName("smtp.gmail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("jorliano32@gmail.com", "leandrogmail"));
	email.setSSLOnConnect(true);
	try {
		email.setFrom("jorliano32@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("teste "+conteudo);
		email.addTo("jorliano@hotmail.com");
		email.send();
	} catch (EmailException e) {
		// TODO Auto-generated catch block
		// Alerta.info("reeo ao enviar o email);
		e.printStackTrace();
	}

 
  
	 

 }
//pesquisar tipo prosutos
 public  void pesquisar() {	
		 paginaAtual = 0;
	  listaProduto = new ProdutoControler().buscaProdutoPor(categoria, ordenar, ordenarTipo, priceMin, priceMax,paginaAtual);		
 }
//pesquisar tipo prosutos
 public  void pesquisarPaginas() {					
	 listaProduto = new ProdutoControler().buscaProdutoPor(categoria, ordenar, ordenarTipo, priceMin, priceMax,paginaAtual);		
 }
//paginar
	 public void paginarAnterio(){
		 
		 if(paginaAtual >= 12){			
			 paginaAtual = paginaAtual - 12;
			 pesquisarPaginas();
		 }
	 }      
	 public void paginarProximo(){
		 if(paginaAtual == 0){
			 pesquisarPaginas();
			 paginaAtual =12;
		 }			 
		 if(paginaAtual >= 12){
			 pesquisarPaginas();
			 paginaAtual =paginaAtual+12;
		 }
		     
	 }
	
	public Part getFoto() {
		return foto;
	}
	public void setFoto(Part foto) {
		this.foto = foto;
	}
	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getNomeMenssage() {
		return nomeMenssage;
	}
	public void setNomeMenssage(String nomeMenssage) {
		this.nomeMenssage = nomeMenssage;
	}
	public String getEmailMenssage() {
		return emailMenssage;
	}
	public void setEmailMenssage(String emailMenssage) {
		this.emailMenssage = emailMenssage;
	}
	public String getConteudoMenssage() {
		return conteudoMenssage;
	}
	public void setConteudoMenssage(String conteudoMenssage) {
		this.conteudoMenssage = conteudoMenssage;
	}
	public String getTelefoneMenssage() {
		return telefoneMenssage;
	}
	public void setTelefoneMenssage(String telefoneMenssage) {
		this.telefoneMenssage = telefoneMenssage;
	}
	public String getObjetivoMenssage() {
		return objetivoMenssage;
	}
	public void setObjetivoMenssage(String objetivoMenssage) {
		this.objetivoMenssage = objetivoMenssage;
	}
	public String getOrdenar() {
		return ordenar;
	}
	public void setOrdenar(String ordenar) {
		this.ordenar = ordenar;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getOrdenarTipo() {
		return ordenarTipo;
	}
	public void setOrdenarTipo(String ordenarTipo) {
		this.ordenarTipo = ordenarTipo;
	}
	public double getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(double priceMin) {
		this.priceMin = priceMin;
	}
	public double getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(double priceMax) {
		this.priceMax = priceMax;
	}
	public List getListaProduto() {
		return listaProduto;
	}
	public void setListaProduto(List listaProduto) {
		this.listaProduto = listaProduto;
	}
	public int getPaginaAtual() {
		return paginaAtual;
	}
	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	

	

	
	
}
