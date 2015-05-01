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

