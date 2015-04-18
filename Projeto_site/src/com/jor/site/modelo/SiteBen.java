package com.jor.site.modelo;

import java.awt.Image;
import java.awt.ImageCapabilities;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;



import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import javax.swing.ImageIcon;

import com.jor.site.controle.SiteControler;
import com.jor.site.entidade.Site;
import com.jor.site.util.Alerta;
import com.jor.site.util.Validar;

@ManagedBean(name="benSite")
@SessionScoped
public class SiteBen {
   
	Site site = new Site();
    SiteControler comando = new SiteControler();
    String caminho;
    private String imagem;
    private String titulo;
    private String conteudo;
    private String video;
    private Part foto;
    
    Validar util = new Validar();
    public SiteBen(){
    	site = (Site) comando.buscaSite();       
    }  
    @PostConstruct
    public void load(){
    	site = (Site) comando.buscaSite();
    	System.out.println("testando");
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
	   return "siteconteudo.xhtml";
   }
   public String trabalho2(){
	   imagem = site.getUrlImagem2();
	   titulo = site.getTitulo2();
	   conteudo = site.getConteudo2();
	   video = site.getVideo2();
	   return "siteconteudo.xhtml";
   }
   public String trabalho3(){
	   imagem = site.getUrlImagem3();
	   titulo = site.getTitulo3();
	   conteudo = site.getConteudo3();
	   video = site.getVideo3();
	   return "siteconteudo.xhtml";
   }
   public String trabalho4(){
	   imagem = site.getUrlImagem4();
	   titulo = site.getTitulo4();
	   conteudo = site.getConteudo4();
	   video = site.getVideo4();
	   return "siteconteudo.xhtml";
   }
   public String trabalho5(){
	   imagem = site.getUrlImagem5();
	   titulo = site.getTitulo5();
	   conteudo = site.getConteudo5();
	   video = site.getVideo5();
	   return "siteconteudo.xhtml";
   }
   public String trabalho6(){
	   imagem = site.getUrlImagem6();
	   titulo = site.getTitulo6();
	   conteudo = site.getConteudo6();
	   video = site.getVideo6();
	   return "siteconteudo.xhtml";
   }
   public String trabalho7(){
	   imagem = site.getUrlImagem7();
	   titulo = site.getTitulo7();
	   conteudo = site.getConteudo7();
	   video = site.getVideo7();
	   return "siteconteudo.xhtml";
   }
   public String trabalho8(){
	   imagem = site.getUrlImagem8();
	   titulo = site.getTitulo8();
	   conteudo = site.getConteudo8();
	   video = site.getVideo8();
	   return "siteconteudo.xhtml";
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

	

	

	
	
}
