package com.jor.site.entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empreendedor")
public class Empreendedor  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name= "nome")
	private String Nome;
	
	@Column(name= "cpf")
	private String Cpf;
	
	@Column(name= "endereco")
	private String Endereco;
	
	@Column(name= "cidade")
	private String Cidade;
	
	@Column(name= "telefone")
	private String Telefone;
	
	@Column(name= "email")
	private String Email;
	
	@Column(name= "cep")
	private String Cep;
	
	@Column(name= "flp")
	private String Flp;
	
	@Column(name= "senhaFlp")
	private String SenhaFlp;
	
	@Column(name= "senhaEmail")
	private String SenhaEmail;
	
	@Column(name= "dataNacimento")
	private String DataNacimento;
	
	@Column(name= "dataCadastro")
	private String DataCadastro;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}	
	public String getDataNacimento() {
		return DataNacimento;
	}
	public void setDataNacimento(String dataNacimento) {
		DataNacimento = dataNacimento;
	}
	public String getDataCadastro() {
		return DataCadastro;
	}
	public void setDataCadastro(String string) {
		DataCadastro = string;
	}
	
	public String getFlp() {
		return Flp;
	}
	public void setFlp(String flp) {
		Flp = flp;
	}
	public String getSenhaFlp() {
		return SenhaFlp;
	}
	public void setSenhaFlp(String senhaFlp) {
		SenhaFlp = senhaFlp;
	}
	public String getSenhaEmail() {
		return SenhaEmail;
	}
	public void setSenhaEmail(String senhaEmail) {
		SenhaEmail = senhaEmail;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		Cep = cep;
	}
	
	
}

