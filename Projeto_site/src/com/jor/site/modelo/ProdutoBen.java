package com.jor.site.modelo;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jor.site.controle.ProdutoControler;
import com.jor.site.entidade.Produto;
import com.jor.site.util.Alerta;

@ManagedBean(name="benProduto")
@SessionScoped
public class ProdutoBen {
   
	Produto produto = new Produto();
	Produto produtoselecionado = new Produto();
	ProdutoControler comando = new ProdutoControler();
	private int quantidade = 1;
	List lista = new ArrayList();
	
	public ProdutoBen(){
		lista = comando.listarDados();
	}
	
	public String incluir()
	{   
		produto = new Produto();
		produto.setQuantidade(0);
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");       		
		produto.setDataCadastro(sdf.format(new Date()));
		return "configureproduto.xhtml";
	}
	public String configurePg()	{   
					
		return "configureproduto.xhtml";
	}
	public String cadastrar()
	{
		
		if(produto.getId() == 0)
		{
			produtoselecionado = (Produto) comando.buscaProdutoNome(produto.getNome());			
			if(produtoselecionado.getNome() == null && produtoselecionado.getCodigo() == 0){
				produto.setQuantidade(quantidade);
				comando.inserir(produto);
				lista = comando.listarDados();
				produto = new Produto();	
				quantidade = 1;
			}		
			else{
				Alerta.error("produto já existe");
				return null;
			}				
			
		}else
		{
			produto.setQuantidade(quantidade + produto.getQuantidade());
			comando.alterar(produto);
			lista = comando.listarDados();
			produto = new Produto();	
			quantidade = 1;
		}
		
		return "produto.xhtml";
		
	}
	public String deletar()
	{  		
		comando.deletar(produto);		
		lista = comando.listarDados();
		produto = new Produto();
		return "produto.xhtml";
	}
	public String buscaProduto()
	{
		lista = comando.buscaProdutos(produto.getNome());
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
