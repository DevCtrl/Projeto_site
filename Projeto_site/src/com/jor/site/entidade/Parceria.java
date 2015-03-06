package com.jor.site.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parceria")
public class Parceria {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name= "nome")
	private String Nome;
	@Column(name= "endereco")
	private String Endereco;
	@Column(name= "contato")
	private String Contato;
	@Column(name= "cnpj")
	private String Cnpj;
	@Column(name= "fone1")
	private String Fone1;
	@Column(name= "fone2")
	private String Fone2;
	@Column(name= "email")
	private String Email;
	@Column(name= "url")
	private String Url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getContato() {
		return Contato;
	}
	public void setContato(String contato) {
		Contato = contato;
	}
	public String getCnpj() {
		return Cnpj;
	}
	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}
	public String getFone1() {
		return Fone1;
	}
	public void setFone1(String fone1) {
		Fone1 = fone1;
	}
	public String getFone2() {
		return Fone2;
	}
	public void setFone2(String fone2) {
		Fone2 = fone2;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	
}
