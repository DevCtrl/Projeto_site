package com.jor.site.modelo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.jor.site.controle.ClienteControler;
import com.jor.site.controle.ProdutoControler;
import com.jor.site.controle.VendaControler;
import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.Venda;
import com.jor.site.util.Alerta;

@ManagedBean(name="ben")
@SessionScoped
public class VendaBen {
   
	Produto pd = new Produto();
	Cliente cli = new Cliente();
	Cliente cliPesquisado = new Cliente();
	Venda vd = new Venda();
	ProdutoControler comando = new ProdutoControler();
	ClienteControler comandoCli = new ClienteControler();
	VendaControler comandoVd = new VendaControler();
	List lisPro = new ArrayList();
	List<Produto> lisCarrinho = new ArrayList<Produto>();
	private String ClientePesquisa;
	private int quantidade = 1;
	
	private double subtotal=0;
	private double total=0;
	private int desconto = 0;
	private double troco = 0;
	private double dinheiro = 0;
	private boolean tipoPagamento ;
	
	
	public VendaBen(){
		lisPro = comando.listarDados();
		
	}
		
	public String add()
	{
		//if(!lisCarrinho.isEmpty())
		//	System.out.println(lisCarrinho.get(0).getNome());
		subtotal = quantidade * pd.getValor_Revenda();
		pd.setComprado(subtotal);
		pd.setQuantidade(quantidade);		
		lisCarrinho.add(pd);
		
		total = total + subtotal;
		
		quantidade = 1;
	   	return  "vendas.xhtml";
	}
	public void remove()
	{
		total = total - pd.getComprado();
		lisCarrinho.remove(pd);
	}
	public String finalizarCompra()
	{
	  if(getSubtotal() <= getDinheiro()){	  	  
			if(!lisCarrinho.isEmpty()){
				for (Produto produto : lisCarrinho) {
					if(cli.getId() == 0)
					   cli.setId(255);
					
					vd.setCliente(cli);
					vd.setProduto(pd);
					vd.setData(new Date());
					
					comandoVd.inserir(vd);				
				}	
				Alerta.info("venda foi  finalizada com sucesso");
				lisCarrinho.clear();
				cli = new Cliente();
			}			
			total = 0;
			desconto = 0;
			subtotal = 0;
			troco = 0;	
			dinheiro = 0;
		return "vendas.xhtml";
	  }
	  else{
		  Alerta.error("Valor em dinheiro é menor que o valor a ser pago");
		  return null;
	  }
	}
	public void buscaProduto()
	{  			
		lisPro = comando.buscaProdutos(pd.getNome());		
		
	}	
	public String buscaCliente()
	{ 
		cliPesquisado = (Cliente) comandoCli.buscaCliente(ClientePesquisa); 
		if(cliPesquisado.getId() != 0)	{			
			cli.setNome(cliPesquisado.getNome());
			cli = cliPesquisado;
		}			
		else
			cli.setNome(ClientePesquisa+" não e cliente");
		return "null";
	}
	public String buscapg(){
		return "configurevenda.xhtml";
	}
	public String cancelarCompra() {
		lisCarrinho.clear();
		total = 0;
		return  "Venda.xhtml";
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

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public double getSubtotal() {	
			
		return subtotal = total - (total*desconto)/100;
	}

	public double getTroco() {
		if(dinheiro >= subtotal)
			troco = dinheiro - subtotal;
		else
		   troco = 0;	
		return troco;
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	public boolean isTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(boolean tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	

	

	
	
}
