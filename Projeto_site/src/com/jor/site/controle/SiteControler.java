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

import javax.imageio.ImageIO;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
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
    public void salvarImagem(String caminho,String nome) throws IOException
    {
    	    	
    	
    //	System.out.println(caminho);
//    	File file = new File("/resources/bootstrap/imagens/newfoto.jpg");
    	InputStream input = getClass().getResourceAsStream("WebContent/resources/bootstrap/imagens/newfoto.jpg");  
    	byte conteudo[] = new byte[input.available()]; 
    	input.read(conteudo);
    	
    	  
    //	
    //	String extension = caminho;
    	
        FileOutputStream outPut = new FileOutputStream(new File("WebContent/resources/bootstrap/imagens/site/trabalhos/","negocio2.jpg"));
        outPut.write(conteudo);
        input.close();
        outPut.flush();
        outPut.close();
    	Alerta.info("sucesso");
        
        System.out.println("salvo");
        
        // Lendo de um input stream
   //     InputStream is = new BufferedInputStream(
   //         new FileInputStream("/bootstrap/imagens/newfoto.jpg"));
  //      BufferedImage image = ImageIO.read(is);


      //Alerta.info("sucesso");
      System.out.println("sucesso");
    	
    /*	BufferedImage input = toBufferedImage(image); 
    	BufferedImage img = (BufferedImage) image;
		String extension = caminho.substring(caminho.lastIndexOf(".") + 1);			
		BufferedImage bi = new BufferedImage(img.getWidth(),
		img.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D grph = (Graphics2D) bi.getGraphics();
		grph.drawImage(img, 0, 0, null);
		grph.dispose();
		ImageIO.write(bi, extension,
			    new File("WebContent/resources/bootstrap/imagens/site/trabalhos/"+nome));
		
   */
    }
}
