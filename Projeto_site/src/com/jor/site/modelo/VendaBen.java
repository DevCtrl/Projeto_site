package com.jor.site.modelo;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	Produto produtoTroca1 = new Produto();
	Produto produtoTroca2 = new Produto();
	Cliente cli = new Cliente();
	Cliente cliPesquisado = new Cliente();
	Venda vd = new Venda();
	ProdutoControler comando = new ProdutoControler();
	ClienteControler comandoCli = new ClienteControler();
	VendaControler comandoVd = new VendaControler();
	List<Produto> lisPro = new ArrayList<Produto>();
	List<Produto> lisCarrinho = new ArrayList<Produto>();
	List<Produto> lisVendido = new ArrayList<Produto>();
	List<Cliente> lisCli = new ArrayList<Cliente>();
	private String ClientePesquisa;
	private int quantidade = 1;
	
	private double subtotal=0;
	private double total=0;
	private int desconto = 0;
	private double troco = 0;
	private double dinheiro = 0;
	private double trocaValor=0.0;
	private String tipoValorTroca;
	private boolean tipoPagamento ;
	private String data;
	private String dataPesquisaVenda;
	private Double totalPesquisaVenda = 0.0;	
	private int quantidadeTroca1 = 0;
	private int quantidadeTroca2 = 0;
	
	public VendaBen(){
		
		
		  lisPro = comando.listarDados("Produto");
		  lisCli = comandoCli.listarDados("Cliente");
	}
		
	public String add()
	{
	 Produto pesquisaEstque = new Produto();
	 pesquisaEstque = (Produto) comando.buscarClassePorId("Produto",pd.getId());
	 if(pesquisaEstque == null)
		 pesquisaEstque = new Produto();
	    if(pesquisaEstque.getQuantidade() >= getQuantidade()){
			subtotal = quantidade * pd.getValor_Revenda();
			pd.setComprado(subtotal);
			pd.setQuantidade(quantidade);		
			lisCarrinho.add(pd);
			
			total = total + subtotal;
			
			
			quantidade = 1;
		   	return  "vendas.xhtml";
	    }else{
			  Alerta.error("Quantidade especificada é maior que  a quantidade em estoque");
			  return null;
		} 	
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
				for (int i =0;i<lisCarrinho.size();i++) {
					if(cli.getId() == 0 )
					   cli.setId(255);
					
					vd.setCliente(cli);
					pd = (Produto) comando.buscarClassePorId("Produto",lisCarrinho.get(i).getId());				
					vd.setProduto(pd);								
					vd.setData(new SimpleDateFormat("dd/MM/yyyy").format(new Date()) );
			    	vd.setComprado(lisCarrinho.get(i).getComprado());
					
					
					comandoVd.inserir(vd,"Venda realizada com sucesso");
					//diminuir do estoque
					comandoVd.diminuirEstoque(lisCarrinho.get(i).getId(), lisCarrinho.get(i).getQuantidade());
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
	public void buscaVenda(){
		cliPesquisado = (Cliente) comandoCli.buscarClassePorNome("Cliente",cliPesquisado.getNome()); 
		if(cliPesquisado == null){
			cliPesquisado = new Cliente();
		}
		if(cliPesquisado.getId() != 0)	{			
			lisVendido = comandoVd.buscaVenda(cliPesquisado.getId(),dataPesquisaVenda);
			if(lisVendido.isEmpty()){
				Alerta.error("Nenhuma pesquisa foi encontrada");
				totalPesquisaVenda = 0.0;
			}
				
			else{
				for (int i = 0; i < lisVendido.size(); i++) {
					totalPesquisaVenda = totalPesquisaVenda+lisVendido.get(i).getComprado();
				}
			}
				
		}else
		{
			Alerta.error("Selecione um cliente");
		}				
	}
	public void addTroca(){				
		  quantidadeTroca1 = 1;		
	}
	public void addTroca2(){				
		  quantidadeTroca2 = 1;			  
	}
	public void comparaTroca1()
	{							
		if(produtoTroca1.getId() != 0){
		  produtoTroca1.setComprado(quantidadeTroca1*produtoTroca1.getValor_Revenda());		
		  
		}
	}
	public void comparaTroca2()
	{  			
		
		if(produtoTroca2.getId() != 0){
			produtoTroca2.setComprado(quantidadeTroca2*produtoTroca2.getValor_Revenda());
			if(produtoTroca1.getComprado() > produtoTroca2.getComprado()){
				  trocaValor = produtoTroca1.getComprado() - produtoTroca2.getComprado();
				  tipoValorTroca = "Você tem Credito ";
			}
		   else{
				  trocaValor = produtoTroca2.getComprado() - produtoTroca1.getComprado();
				  tipoValorTroca = "Falta Pagar  ";
		   }
	   }
	
	}
	public void trocar(){
		
		if(produtoTroca1.getNome()!= "" && produtoTroca2.getNome()!= ""){
			
			comandoVd.diminuirEstoque(produtoTroca1.getId(), quantidadeTroca1);
		    comandoVd.aumentaEstoque(produtoTroca2.getId(), quantidadeTroca2);
		   
		    produtoTroca1 = new Produto();
		    produtoTroca2 = new Produto();
		    quantidadeTroca2 =1;
		    quantidadeTroca1 =1;
		    trocaValor = 0.0;
		    tipoValorTroca="";
		    
		}
		else
			Alerta.error("Selecione um produto cadastrado");
		
	}
	public void buscaProduto()
	{  			
		lisPro = comando.buscarListaPorNome("Produto", pd.getNome());		
		
	}	
	public String buscaCliente()
	{ 
		cliPesquisado = (Cliente) comandoCli.buscarClassePorNome("Cliente",ClientePesquisa); 
		if(cliPesquisado == null)
			cliPesquisado = new Cliente();
		if(cliPesquisado.getId() != 0)	{			
			cli.setNome(cliPesquisado.getNome());
			cli = cliPesquisado;
		}			
		else
			cli.setNome(ClientePesquisa+" não e cliente");
		return "null";
	}
	public void buscaClientes(){
		lisCli = comandoCli.buscarListaPorNome("Cliente",ClientePesquisa);
	}
	public String buscapg(){
		if(cliPesquisado.getId() != 0)
		{
			lisPro = comando.listarDados("Produto");
			 if(lisCarrinho.size() > 0)
			  {
				
				for (int i = 0; i < lisCarrinho.size();i++) {					
					for (int j = 0; j < lisPro.size(); j++) {						
						if(lisCarrinho.get(i).getNome().equals(lisPro.get(j).getNome())){							
							lisPro.get(j).setQuantidade(lisPro.get(j).getQuantidade()-lisCarrinho.get(i).getQuantidade());											
						    
						}
							
					}
				}
			}
			 return "configurevenda.xhtml";
		}		
		else{
			Alerta.error("Selecione um cliente para venda");
			return null;
		}			
		
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
		this.lisPro = comando.listarDados("Produto");
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

	public Double getTotalPesquisaVenda() {
		return totalPesquisaVenda;
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

	public List<Produto> getLisVendido() {
		return lisVendido;
	}

	public void setLisVendido(List<Produto> lisVendido) {
		this.lisVendido = lisVendido;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Cliente getCliPesquisado() {
		return cliPesquisado;
	}

	public void setCliPesquisado(Cliente cliPesquisado) {
		this.cliPesquisado = cliPesquisado;
	}

	public String getDataPesquisaVenda() {
		return dataPesquisaVenda;
	}

	public void setDataPesquisaVenda(String dataPesquisaVenda) {
		this.dataPesquisaVenda = dataPesquisaVenda;
	}

	public List<Cliente> getLisCli() {
		return lisCli;
	}

	public void setLisCli(List<Cliente> lisCli) {
		this.lisCli = lisCli;
	}

	public Produto getProdutoTroca1() {
		return produtoTroca1;
	}

	public void setProdutoTroca1(Produto produtoTroca1) {
		this.produtoTroca1 = produtoTroca1;
	}

	public Produto getProdutoTroca2() {
		return produtoTroca2;
	}

	public void setProdutoTroca2(Produto produtoTroca2) {
		this.produtoTroca2 = produtoTroca2;
	}

	public int getQuantidadeTroca1() {
		return quantidadeTroca1;
	}

	public void setQuantidadeTroca1(int quantidadeTroca1) {
		this.quantidadeTroca1 = quantidadeTroca1;
	}

	public int getQuantidadeTroca2() {
		return quantidadeTroca2;
	}

	public void setQuantidadeTroca2(int quantidadeTroca2) {
		this.quantidadeTroca2 = quantidadeTroca2;
	}

	public double getTrocaValor() {
		return trocaValor;
	}

	public void setTrocaValor(double trocaValor) {
		this.trocaValor = trocaValor;
	}

	public String getTipoValorTroca() {
		return tipoValorTroca;
	}

	public void setTipoValorTroca(String tipoValorTroca) {
		this.tipoValorTroca = tipoValorTroca;
	}

	
	

	

	
	
}
