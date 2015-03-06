package com.jor.site.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="site")
public class Site {
  
	@Id
	private int id;
	
	@Column(name="titulo1")
	private String Titulo1;
	@Column(name="titulo2")
	private String Titulo2;
	@Column(name="tituloImagem1")
	private String TituloImagem1;
	@Column(name="tituloImagem2")
	private String TituloImagem2;
	@Column(name="conteudo1")
	private String Conteudo1;
	@Column(name="conteudo2")
	private String Conteudo2;
	@Column(name="video1")
	private String Video1;
	@Column(name="video2")
	private String Video2;
	@Column(name="video3")
	private String Video3;
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
	public String getTitulo2() {
		return Titulo2;
	}
	public void setTitulo2(String titulo2) {
		Titulo2 = titulo2;
	}
	public String getTituloImagem1() {
		return TituloImagem1;
	}
	public void setTituloImagem1(String tituloImagem1) {
		TituloImagem1 = tituloImagem1;
	}
	public String getTituloImagem2() {
		return TituloImagem2;
	}
	public void setTituloImagem2(String tituloImagem2) {
		TituloImagem2 = tituloImagem2;
	}
	public String getConteudo1() {
		return Conteudo1;
	}
	public void setConteudo1(String conteudo1) {
		Conteudo1 = conteudo1;
	}
	public String getConteudo2() {
		return Conteudo2;
	}
	public void setConteudo2(String conteudo2) {
		Conteudo2 = conteudo2;
	}
	public String getVideo1() {
		return Video1;
	}
	public void setVideo1(String video1) {
		Video1 = video1;
	}
	public String getVideo2() {
		return Video2;
	}
	public void setVideo2(String video2) {
		Video2 = video2;
	}
	public String getVideo3() {
		return Video3;
	}
	public void setVideo3(String video3) {
		Video3 = video3;
	}
	
	
}
