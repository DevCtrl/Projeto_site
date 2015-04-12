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

	

	//public Part getFile() {
	//	return foto;
	//}

	//public void setFile(Part foto) {
//		this.foto = foto;
//	}	

	
	
}
