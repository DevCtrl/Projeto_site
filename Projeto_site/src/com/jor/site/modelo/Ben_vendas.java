package com.jor.site.modelo;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardUpLeftHandler;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.jor.site.controle.Control_cliente;
import com.jor.site.controle.Control_produto;
import com.jor.site.controle.Control_venda;
import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.Venda;
import com.jor.site.util.Alertas;

@ManagedBean(name="ben")
@SessionScoped
public class Ben_vendas {
   
	Produto pd = new Produto();
	Cliente cli = new Cliente();
	Cliente CliPesquisado = new Cliente();
	Venda vd = new Venda();
	Control_produto comando = new Control_produto();
	Control_cliente comandoCli = new Control_cliente();
	Control_venda comandoVd = new Control_venda();
	List lisPro = new ArrayList();
	List<Produto> lisCarrinho = new ArrayList<Produto>();
	private String ClientePesquisa;
	private int quantidade = 1;
	private double subtotal=0;
	private double total=0;
	
	
	public void teste(ActionEvent evt){
		System.out.println("teste evento");
		Alertas ms = new Alertas();
		ms.comfirmar("message certo");
	}
	
	
	public Ben_vendas(){
		lisPro = comando.Listar_Dados();
		
	}
		
	public String Add()
	{
		//if(!lisCarrinho.isEmpty())
		//	System.out.println(lisCarrinho.get(0).getNome());
		subtotal = quantidade * pd.getValor_Revenda();
		pd.setComprado(subtotal);
		pd.setQuantidade(quantidade);		
		lisCarrinho.add(pd);
		
		total = total + subtotal;
		
		quantidade = 1;
	   	return  "Vendas.xhtml";
	}
	public void Remove()
	{
		total = total - pd.getComprado();
		lisCarrinho.remove(pd);
	}
	public void FinalizarCompra(ActionEvent evt)
	{
		
		if(!lisCarrinho.isEmpty()){
			for (Produto produto : lisCarrinho) {
				if(cli.getId() == 0)
				   cli.setId(255);
				
				vd.setCliente(cli);
				vd.setProduto(pd);
				vd.setData(new Date());
				
				comandoVd.inserir(vd);				
			}					
			lisCarrinho.clear();
			cli = new Cliente();
		}			
		total = 0;
	}
	public String BuscaProduto()
	{  
		System.out.println("teste busca "+pd.getNome());		
		lisPro = comando.BuscaProdutos(pd.getNome());		
		return "null";
	}	
	public String BuscaCliente()
	{ 
		CliPesquisado = (Cliente) comandoCli.BuscaCliente(ClientePesquisa); 
		if(CliPesquisado.getId() != 0)	{
			System.out.println(ClientePesquisa+"  teste");
			cli.setNome(CliPesquisado.getNome());
			cli.setId(CliPesquisado.getId());
		}
			
		else
			cli.setNome(ClientePesquisa+" não e cliente");
		return "null";
	}
	public String buscapg(){
		return "ConfigureVenda.xhtml";
	}
	
	
	
	public Produto getPd() {
		return pd;
	}
	public void setPd(Produto pd) {
		this.pd = pd;
	}	
	public List getLisPro() {
		return lisPro;
	}
	public void setLisPro(List lisPro) {
		this.lisPro = lisPro;
	}
	public List getLisCarrinho() {
		return lisCarrinho;
	}
	public void setLisCarrinho(List lisCarrinho) {
		this.lisCarrinho = lisCarrinho;
	}
	public Cliente getCli() {
		return cli;
	}
	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	public Venda getVd() {
		return vd;
	}
	public void setVd(Venda vd) {
		this.vd = vd;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getClientePesquisa() {
		return ClientePesquisa;
	}

	public void setClientePesquisa(String clientePesquisa) {
		ClientePesquisa = clientePesquisa;
	}
	

	

	
	
}
