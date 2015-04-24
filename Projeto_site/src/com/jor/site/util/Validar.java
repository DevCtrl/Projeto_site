package com.jor.site.util;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import javax.swing.ImageIcon;

import org.apache.commons.compress.utils.IOUtils;
import org.omg.CORBA.portable.InputStream;


public class Validar {
  
	
	
	/* public static byte[] tratarImagem(java.io.InputStream inputStream) {
		 byte[] byteArray = null;
		    if (inputStream != null) {
		     try {
		      byteArray = IOUtils.toByteArray(inputStream);
		     } catch (IOException e) {
		        e.printStackTrace();
		     }
		 }
		 return byteArray;
		 }
	 public byte[] setThumbnail(byte[] arquivo, String extensao) {
		  ImageIcon imageIcon = new ImageIcon(arquivo);
		  Image inImage = imageIcon.getImage();
		  double scale = 100 / (double) inImage.getWidth(null);
		  int scaledW = (int) (scale * inImage.getWidth(null));
		  int scaledH = (int) (scale * inImage.getHeight(null));
		  BufferedImage outImage = new BufferedImage(scaledW, scaledH, BufferedImage.TYPE_INT_RGB);
		  AffineTransform tx = new AffineTransform();
		 if (scale < 1.0d) {
		 tx.scale(scale, scale);
		 }
		 Graphics2D g2d = outImage.createGraphics();
		 g2d.drawImage(inImage, tx, null);
		 g2d.dispose();
		 try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
		    ImageIO.write(outImage, extensao, baos);
		 return baos.toByteArray();
		 } 
		 catch (IOException e) {
		    System.out.println(e.getMessage());
		 }
		 return null;
		 }	*/
/*Ler arquivo part e gera um arquivo q serar salvo */	
	 private final int limitTamanho = 2000000;
	    private final String tipoArquivo = "jpeg|jpg|gif|png";	   

	    public Validar() {
	    }
      
	    public String Upload(Part foto ,String caminho) {
	        String arquivoSalvo = "semImagens.jpg";
	        try {	        	
	        	
	            if (foto.getSize() > 0) {
	                String nomeArquivo = getFilename(foto);	               
	                if (verificaTipoArquivo(nomeArquivo)) {
	                    if (foto.getSize() > this.limitTamanho) {
	                        Alerta.error("Tamanho muito grande");
	                    } else {
	                    	
	                        String nomeAtualArquivo = nomeArquivo;
	                        String ext = nomeAtualArquivo.substring(nomeAtualArquivo.lastIndexOf("."), nomeAtualArquivo.length());	                      
	                        String fileSavePath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("imagens");
	                        fileSavePath = fileSavePath.substring(0,fileSavePath.indexOf("/imagens"));
	                        fileSavePath = fileSavePath+"/resources/bootstrap/imagens/site/"+caminho;	                        
	                      
	                        System.out.println(fileSavePath);
	                        
	                        try {
	                        	System.out.println(foto.getSize());
	                            
	                            java.io.InputStream input =   foto.getInputStream();
	                            byte[] conteudoArquivo = new byte[input.available()];
	                            input.read(conteudoArquivo);	                           
	                                                  	                            
	                            FileOutputStream outPut = new FileOutputStream(new File(fileSavePath));
	                            outPut.write(conteudoArquivo);
	                            input.close();
	                            outPut.flush();
	                            outPut.close();
	                           
	                                                      
                             
	                        } catch (IOException e) {
	                            arquivoSalvo = "semImagens.jpg";
	                        }
	                    }

	                } else {
	                    arquivoSalvo = "semImagens.jpg";
	                    System.out.println("arquivo nao salvo");
	                }
	            }
	        } catch (Exception ex) {
	            arquivoSalvo = "semImagens.jpg";
	        }
	        return arquivoSalvo;
	    }

	    private boolean verificaTipoArquivo(String nomeArquivo) {
	        if (nomeArquivo.length() > 0) {
	            String[] tipoParts = nomeArquivo.split("\\.");
	            if (tipoParts.length > 0) {
	                String ext = tipoParts[tipoParts.length - 1];
	                return this.tipoArquivo.contains(ext);

	            }

	        }
	        return false;
	    }

	    private String getFilename(Part foto) {
	        for (String cd : foto.getHeader("content-disposition").split(";")) {
	            if (cd.trim().startsWith("filename")) {
	                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
	            }
	        }
	        return null;
	    }

	}

