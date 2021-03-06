package com.jor.site.modelo;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import com.jor.site.controle.ProdutoControler;
import com.jor.site.entidade.Produto;
import com.jor.site.util.Alerta;
import com.jor.site.util.Validar;

@ManagedBean(name="benProduto")
@SessionScoped
public class ProdutoBen {
   
	Produto produto = new Produto();
	Produto produtoselecionado = new Produto();
	ProdutoControler comando = new ProdutoControler();
	private Part foto = null;
	private int quantidade = 1;
	List lista = new ArrayList();
	
	public ProdutoBen(){
		lista = comando.listarDados("Produto");
		
	}
	public String criarImagem1() throws IOException{
		Validar util = new Validar();
		if(foto != null && foto.getSize() != 0) {				
    	 util.Upload(foto,"produtos/"+produto.getNome().trim()+".jpg");
    	 produto.setUrlImagem("/resources/bootstrap/imagens/site/produtos/"+produto.getNome().trim()+".jpg");   	 
    	
    	 foto.delete();
		}	 
		
    	return null;
    }
	public String incluir()
	{   
		produto = new Produto();
		produto.setQuantidade(0);
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");       		
		produto.setDataCadastro(sdf.format(new Date()));
		produto.setUrlImagem("/resources/bootstrap/imagens/servico/interrogacao.jpeg");
		return "configureproduto.xhtml";
	}
	public String configurePg()	{   
					
		return "configureproduto.xhtml";
	}
	public String cadastrar() throws IOException
	{
		
		if(produto.getId() == 0)
		{
			produtoselecionado = (Produto) comando.buscarClassePorNome("Produto",produto.getNome());	
			if(produtoselecionado == null)
				produtoselecionado = new Produto();
			if(produtoselecionado.getNome() == null && produtoselecionado.getCodigo() == 0){
				produto.setQuantidade(quantidade);
				criarImagem1();
				if(produto.getUrlImagem() == "" || produto.getUrlImagem() == null){
					produto.setUrlImagem("/resources/bootstrap/imagens/servico/interrogacao.jpeg");
				   
				}
				comando.inserir(produto, "Produto "+produto.getNome()+" salvo com sucesso");
				lista = comando.listarDados("Produto");
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
			criarImagem1();			
			comando.alterar(produto,"Dados alterado com sucesso");
			lista = comando.listarDados("Produto");
			produto = new Produto();	
			quantidade = 1;
		}		
		return "produto.xhtml";
		
	}
	public String deletar()
	{  		
		comando.deletar(produto,"Produto "+produto.getNome()+" deletado com sucesso");		
		lista = comando.listarDados("Produto");
		produto = new Produto();
		return "produto.xhtml";
	}
	public String buscaProduto()
	{
		lista = comando.buscarListaPorNome("Produto", produto.getNome());
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
	public Part getFoto() {
		return foto;
	}
	public void setFoto(Part foto) {
		this.foto = foto;
	}
	
	
	
}
