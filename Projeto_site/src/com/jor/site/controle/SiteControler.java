package com.jor.site.controle;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.Site;
import com.jor.site.util.Alerta;
import com.jor.site.util.HibernateUtil;

public class SiteControler {
  Session session;
  
    public void incluir(Site site)
    {
    	session =  HibernateUtil.getSessionFactory().openSession();
    	try
    	{
    		site.setId(1);
		    session.beginTransaction();
		    session.saveOrUpdate(site);
		    session.getTransaction().commit();
		    
		} catch (Exception e) {			
           Alerta.error("Erro ao tentar salvar primeiro conteudo");
		}
    	finally
    	{
    		Alerta.info("Dados salvos com sucesso");
    		session.close();
    	}
    }
    public Object buscaSite() {
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();	    	
	          
	    	  Query q = session.createQuery("from Site where id = 1" );	    	  	    	     	            	         	    	  
	    	  if(q.uniqueResult() == null)  	        	   	        	
   	        	return new Site();   	             	          	  
   	          else 	  
	          return q.uniqueResult();
	    } catch (Exception e) {
	         System.out.println("erro ao pesquisar "+e.getMessage());
	    }
		return null;
		
	}
    //dimiui o conteudo da descrição do produto   
   	public List diminuirTexto(){
   		List<Produto> p = new ArrayList<Produto>();
   		p = new ProdutoControler().listarDados("Produto");
   		
   		for (int i = 0; i < p.size(); i++) {
   			int fim = 50;
   			
   			if( p.get(i).getDescricao() != null){
   			   if(p.get(i).getDescricao().length() < 50)
   				   fim = p.get(i).getDescricao().length();
   			   
   				String texto = p.get(i).getDescricao().substring(0,fim);
   				p.get(i).setDescricao(texto);
   			}else
   				p.get(i).setDescricao("sem texto");
   			
   		}
   		return p;
   	}
   	public List diminuirTextoPesquisado(List<Produto> p){   		
   		
   		for (int i = 0; i < p.size(); i++) {
   			int fim = 50;
   			
   			if( p.get(i).getDescricao() != null){
   			   if(p.get(i).getDescricao().length() < 50)
   				   fim = p.get(i).getDescricao().length();
   			   
   				String texto = p.get(i).getDescricao().substring(0,fim);
   				p.get(i).setDescricao(texto);
   			}else
   				p.get(i).setDescricao("sem texto");
   			
   		}
   		return p;
   	}
}
