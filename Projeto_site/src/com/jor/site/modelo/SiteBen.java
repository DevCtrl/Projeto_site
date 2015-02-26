package com.jor.site.modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name="benSite")
@SessionScoped
public class SiteBen {
    
	private String titulo1 ="Primeiro titulo";
	private String section1 ="meu texto sendo editado neste momento";
	private String tituloImagem1="Primeira Imagem";	
	private String titulo2 ="Segundo titulo";
	private String section2 ="meu texto sendo editado neste momento testando seccão 2";
	private String tituloImagem2="Segunda imagem Imagem";
	
	private String video1 ="http://www.youtube.com/embed/6NbAAmDuv_8?feature=player_detailpage";
	private String video2 ="http://www.youtube.com/embed/QAmdTP2aobM?feature=player_detailpage";
	private String video3 ="http://www.youtube.com/embed/Q3HGbx5s4MU?feature=player_detailpage";
	
	
	public void edite(ActionEvent evt){
		this.titulo1 = getTitulo1();
		this.section1 = getSection1();
		this.tituloImagem1 = getTituloImagem1();
		
	}
	public void editeVideo1(ActionEvent evt){
		setVideo1("http://www.youtube.com/embed/"+getVideo1()+"?feature=player_detailpage");
	}
	public void editeVideo2(ActionEvent evt){
		setVideo2("http://www.youtube.com/embed/"+getVideo1()+"?feature=player_detailpage");
	}
	public void editeVideo3(ActionEvent evt){
		setVideo3("http://www.youtube.com/embed/"+getVideo1()+"?feature=player_detailpage");
	}

	public String getSection1() {
		return section1;
	}

	public void setSection1(String section1) {
		this.section1 = section1;
	}

	public String getTitulo1() {
		return titulo1;
	}

	public void setTitulo1(String titulo1) {
		this.titulo1 = titulo1;
	}

	public String getTituloImagem1() {
		return tituloImagem1;
	}

	public void setTituloImagem1(String tituloImagem1) {
		this.tituloImagem1 = tituloImagem1;
	}

	public String getTitulo2() {
		return titulo2;
	}

	public void setTitulo2(String titulo2) {
		this.titulo2 = titulo2;
	}

	public String getSection2() {
		return section2;
	}

	public void setSection2(String section2) {
		this.section2 = section2;
	}

	public String getTituloImagem2() {
		return tituloImagem2;
	}

	public void setTituloImagem2(String tituloImagem2) {
		this.tituloImagem2 = tituloImagem2;
	}

	public String getVideo1() {
		return video1;
	}

	public void setVideo1(String video1) {
		this.video1 = video1;
	}

	public String getVideo2() {
		return video2;
	}

	public void setVideo2(String video2) {
		this.video2 = video2;
	}

	public String getVideo3() {
		return video3;
	}

	public void setVideo3(String video3) {
		this.video3 = video3;
	}
	
	
}
