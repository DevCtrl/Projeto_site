package com.jor.site.modelo;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.jor.site.controle.Control_produto;
import com.jor.site.entidade.Produto;

@ManagedBean(name="benProduto")
@SessionScoped
public class Ben_produto {
   
	Produto produto = new Produto();
	Control_produto comando = new Control_produto();
	List lista = new ArrayList();
	
	public Ben_produto(){
		lista = comando.Listar_Dados();
	}
	
	public String Incluir()
	{   
		produto = new Produto();				
		return "ConfigureProduto.xhtml";
	}
	public String ConfigurePg()	{   
					
		return "ConfigureProduto.xhtml";
	}
	public String Cadastrar()
	{
		System.out.println("teste produto "+produto.getNome());	
		if(produto.getId() == 0)
		{			
			comando.inserir(produto);
			
		}else
		{
			comando.alterar(produto);
		}
		lista = comando.Listar_Dados();
		produto = new Produto();	
		return "Produto.xhtml";
		
	}
	public String Deletar()
	{  		
		comando.deletar(produto);		
		lista = comando.Listar_Dados();
		produto = new Produto();
		return "Produto.xhtml";
	}
	public String BuscaPro()
	{
		lista = comando.BuscaProdutos(produto.getNome());
		produto = new Produto();
		return "null";
	}

	

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List getLista() {
		return lista ;
	}

	public void setLista(List lista) {
		this.lista = lista;
	}
	
	
	
}
