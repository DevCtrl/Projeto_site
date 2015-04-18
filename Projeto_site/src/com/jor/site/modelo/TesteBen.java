package com.jor.site.modelo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.omg.CORBA.portable.InputStream;



import com.jor.site.controle.SiteControler;
import com.jor.site.util.Validar;

@ManagedBean(name="benTeste")
@RequestScoped
public class TesteBen {
    
	    private String url="#{request.contextPath}/resources/bootstrap/imagens/site/teste3.png";
	    private Part arquivo ;
		private String conteudo;
	    
		 private String imagem = "";
		    private Part foto;


		   
	    
	    public void salvar() throws IOException{
	    	//File file = new File("/home/jorliano/git/Projeto_site/Projeto_site/WebContent/resources/bootstrap/imagens/trees.jpg");    
	    	new SiteControler().salvarImagem("a", "b");
	    }
	    
	    public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		

		public Part getArquivo() {
			return arquivo;
		}

		public void setArquivo(Part arquivo) {
			this.arquivo = arquivo;
		}
		



		public Part getFoto() {
			return foto;
		}



		public void setFoto(Part foto) {
			this.foto = foto;
		}
	
		
		
}
