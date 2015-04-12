package com.jor.site.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.Icon;

@Entity
@Table(name="site")
public class Site {
  
	@Id
	private int id;
	
	@Column(name="titulo1")
	private String Titulo1;
	@Column(name="conteudo1")
	private String Conteudo1;
	@Column(name="urlImagem1")
	private String UrlImagem1;
	@Column(name="video1")
	private String Video1;
	
	@Column(name="titulo2")
	private String Titulo2;
	@Column(name="conteudo2")
	private String Conteudo2;
	@Column(name="urlImagem2")
	private String UrlImagem2;
	@Column(name="video2")
	private String Video2;
	
	
	@Column(name="titulo3")
	private String Titulo3;
	@Column(name="conteudo3")
	private String Conteudo3;
	@Column(name="urlImagem3")
	private String UrlImagem3;
	@Column(name="video3")
	private String Video3;	
	
	@Column(name="titulo4")
	private String Titulo4;
	@Column(name="conteudo4")
	private String Conteudo4;
	@Column(name="urlImagem4")
	private String UrlImagem4;
	@Column(name="video4")
	private String Video4;	
	
	@Column(name="titulo5")
	private String Titulo5;
	@Column(name="conteudo5")
	private String Conteudo5;
	@Column(name="urlImagem5")
	private String UrlImagem5;
	@Column(name="video5")
	private String Video5;	
	
	@Column(name="titulo6")
	private String Titulo6;
	@Column(name="conteudo6")
	private String Conteudo6;
	@Column(name="urlImagem6")
	private String UrlImagem6;
	@Column(name="video6")
	private String Video6;	
	
	@Column(name="titulo7")
	private String Titulo7;
	@Column(name="conteudo7")
	private String Conteudo7;
	@Column(name="urlImagem7")
	private String UrlImagem7;
	@Column(name="video7")
	private String Video7;	
	
	@Column(name="titulo8")
	private String Titulo8;
	@Column(name="conteudo8")
	private String Conteudo8;
	@Column(name="urlImagem8")
	private String UrlImagem8;
	@Column(name="video8")
	private String Video8;	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo1() {
		return Titulo1;
	}
	public void setTitulo1(String titulo1) {
		Titulo1 = titulo1;
	}
	public String getConteudo1() {
		return Conteudo1;
	}
	public void setConteudo1(String conteudo1) {
		Conteudo1 = conteudo1;
	}
	public String getUrlImagem1() {
		return UrlImagem1;
	}
	public void setUrlImagem1(String urlImagem1) {
		UrlImagem1 = urlImagem1;
	}
	public String getVideo1() {
		return Video1;
	}
	public void setVideo1(String video1) {
		Video1 = video1;
	}
	public String getTitulo2() {
		return Titulo2;
	}
	public void setTitulo2(String titulo2) {
		Titulo2 = titulo2;
	}
	public String getConteudo2() {
		return Conteudo2;
	}
	public void setConteudo2(String conteudo2) {
		Conteudo2 = conteudo2;
	}
	public String getUrlImagem2() {
		return UrlImagem2;
	}
	public void setUrlImagem2(String urlImagem2) {
		UrlImagem2 = urlImagem2;
	}
	public String getVideo2() {
		return Video2;
	}
	public void setVideo2(String video2) {
		Video2 = video2;
	}
	public String getTitulo3() {
		return Titulo3;
	}
	public void setTitulo3(String titulo3) {
		Titulo3 = titulo3;
	}
	public String getConteudo3() {
		return Conteudo3;
	}
	public void setConteudo3(String conteudo3) {
		Conteudo3 = conteudo3;
	}
	public String getUrlImagem3() {
		return UrlImagem3;
	}
	public void setUrlImagem3(String urlImagem3) {
		UrlImagem3 = urlImagem3;
	}
	public String getVideo3() {
		return Video3;
	}
	public void setVideo3(String video3) {
		Video3 = video3;
	}
	
	public void setIcon(byte[] setThumbnail) {
		// TODO Auto-generated method stub
		
	}
	public String getTitulo4() {
		return Titulo4;
	}
	public void setTitulo4(String titulo4) {
		Titulo4 = titulo4;
	}
	public String getConteudo4() {
		return Conteudo4;
	}
	public void setConteudo4(String conteudo4) {
		Conteudo4 = conteudo4;
	}
	public String getUrlImagem4() {
		return UrlImagem4;
	}
	public void setUrlImagem4(String urlImagem4) {
		UrlImagem4 = urlImagem4;
	}
	public String getVideo4() {
		return Video4;
	}
	public void setVideo4(String video4) {
		Video4 = video4;
	}
	public String getTitulo5() {
		return Titulo5;
	}
	public void setTitulo5(String titulo5) {
		Titulo5 = titulo5;
	}
	public String getConteudo5() {
		return Conteudo5;
	}
	public void setConteudo5(String conteudo5) {
		Conteudo5 = conteudo5;
	}
	public String getUrlImagem5() {
		return UrlImagem5;
	}
	public void setUrlImagem5(String urlImagem5) {
		UrlImagem5 = urlImagem5;
	}
	public String getVideo5() {
		return Video5;
	}
	public void setVideo5(String video5) {
		Video5 = video5;
	}
	public String getTitulo6() {
		return Titulo6;
	}
	public void setTitulo6(String titulo6) {
		Titulo6 = titulo6;
	}
	public String getConteudo6() {
		return Conteudo6;
	}
	public void setConteudo6(String conteudo6) {
		Conteudo6 = conteudo6;
	}
	public String getUrlImagem6() {
		return UrlImagem6;
	}
	public void setUrlImagem6(String urlImagem6) {
		UrlImagem6 = urlImagem6;
	}
	public String getVideo6() {
		return Video6;
	}
	public void setVideo6(String video6) {
		Video6 = video6;
	}
	public String getTitulo7() {
		return Titulo7;
	}
	public void setTitulo7(String titulo7) {
		Titulo7 = titulo7;
	}
	public String getConteudo7() {
		return Conteudo7;
	}
	public void setConteudo7(String conteudo7) {
		Conteudo7 = conteudo7;
	}
	public String getUrlImagem7() {
		return UrlImagem7;
	}
	public void setUrlImagem7(String urlImagem7) {
		UrlImagem7 = urlImagem7;
	}
	public String getVideo7() {
		return Video7;
	}
	public void setVideo7(String video7) {
		Video7 = video7;
	}
	public String getTitulo8() {
		return Titulo8;
	}
	public void setTitulo8(String titulo8) {
		Titulo8 = titulo8;
	}
	public String getConteudo8() {
		return Conteudo8;
	}
	public void setConteudo8(String conteudo8) {
		Conteudo8 = conteudo8;
	}
	public String getUrlImagem8() {
		return UrlImagem8;
	}
	public void setUrlImagem8(String urlImagem8) {
		UrlImagem8 = urlImagem8;
	}
	public String getVideo8() {
		return Video8;
	}
	public void setVideo8(String video8) {
		Video8 = video8;
	}
	
	
	
	
}
