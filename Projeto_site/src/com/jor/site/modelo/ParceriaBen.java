package com.jor.site.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.eclipse.persistence.jpa.jpql.parser.IsExpressionFactory;

import com.jor.site.controle.ContratoControler;
import com.jor.site.controle.ParceriaControler;
import com.jor.site.controle.ProdutoControler;
import com.jor.site.controle.ProdutoFornecidoControler;
import com.jor.site.controle.VendaControler;
import com.jor.site.entidade.Contrato;
import com.jor.site.entidade.Parceria;
import com.jor.site.entidade.Produto;
import com.jor.site.entidade.ProdutoFornecido;
import com.jor.site.util.Alerta;

@ManagedBean(name="benParceria")
@SessionScoped
public class ParceriaBen {
  
	List listaParceria =  new ArrayList();
	List listaContrato =  new ArrayList();
	List listaProdutoFronecido =  new ArrayList();
	Parceria parceria = new Parceria();
	Contrato contrato = new Contrato();
	Produto p = new Produto();
	Produto produtoSelecionado = new Produto();
	ProdutoFornecido fornecido = new ProdutoFornecido();
	ParceriaControler comandoParceria = new ParceriaControler();
	ContratoControler comandoContrato = new ContratoControler();
	ProdutoFornecidoControler comandoFornecido = new ProdutoFornecidoControler();
	
	private String dataPesquisaFornecido;	
	private String dataContaFornecido;
	private int quantidadeFornecido = 1;
	private int quantidadeFornecidoEditado =0 ;
	
	public ParceriaBen() {
		
		 listaParceria = comandoParceria.listarDados("Parceria");
	}
	public void inserirParceria()
	{
		if(parceria.getId() == 0){		
		   comandoParceria.inserir(parceria,"Vendedor "+parceria.getNome()+" cadastrado com sucesso");
		   parceria = new Parceria();
		} 
		else
		   comandoParceria.alterar(parceria,"Vendedor "+parceria.getNome()+" alterado com sucesso");				
		
		listaParceria = comandoParceria.listarDados("Parceria");
	}
	public void deletarParceria()
	{
		comandoParceria.deletar(Parceria,"Vendedor "+parceria.getNome()+" deletado com sucesso");		
		listaParceria = comandoParceria.listarDados("Parceria");
		
	}
	public void buscaParceria(){		
	    listaParceria = comandoParceria.buscarListaPorNome("Parceria", parceria.getNome());
	}
	public String pagina(){
		return "parcerias.xhtml";
	}
	public void limparCampos(){
		parceria = new Parceria();
		contrato = new Contrato();
		listaProdutoFronecido = new ArrayList();
		listaContrato.clear();
	}
	//Contrato
	
	public void inserirContrato()
	{
	  if(parceria.getId() != 0){
		if(contrato.getId() == 0){
			System.out.println(parceria.getId());
			 contrato.setParceria(parceria);
			 comandoContrato.inserir(contrato," Contrato salvo com sucesso");
		}
		  
		else
		   comandoContrato.alterar(contrato,"Contrato alterado com sucesso");		
		contrato = new Contrato();
		
	  }
	  else{
		  Alerta.error("Selecione um vendedor");
	  }
	}
	public void deletarContrato()
	{
		comandoContrato.deletar(contrato,"Contrato deletado com sucesso");
		contrato = new Contrato();	
		
	}
	public void buscaContratoId(){
	    contrato = (Contrato) comandoContrato.buscarClassePorId("Contrato", contrato.getId());
	}
	//Fornecimento de Produtos
	public String inserirProdutoFornecido()
	{
	  if(parceria.getId() != 0){		
		    SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");  
		    
			 fornecido.setDataCadastro(sdf.format(new Date())); 		  
			 fornecido.setParceria(parceria);			
			 fornecido.setDataContas(getDataContaFornecido());
			 fornecido.setNome(p.getNome());
			 fornecido.setQuantidade(getQuantidadeFornecido());
			 fornecido.setValor_Varejo(p.getValor_Varejo());
			 
			 p = (Produto) new ProdutoControler().buscarClassePorId("ProdutoFornecido", p.getId());
			 System.out.println(p.getQuantidade()+" < "+getQuantidadeFornecido());
			 if(p.getQuantidade() > getQuantidadeFornecido()){
			    comandoFornecido.inserir(fornecido,"Fornecimento salvo com sucesso");
			    new VendaControler().diminuirEstoque(p.getId(), getQuantidadeFornecido());
			 }else
				 Alerta.error("quantidade especificada é maior do que no estoque");
		}			 
	  else{
		  Alerta.error("Selecione um vendedor");
	  }
	  return "parceria.xhtml";
	}
	public String editarProdutoFornecido(){
		p = (Produto) new ProdutoControler().buscarClassePorNome("ProdutoFornecido", fornecido.getNome());		
		
		if(fornecido.getQuantidade() > quantidadeFornecidoEditado){
			if(p.getQuantidade() >   fornecido.getQuantidade() - quantidadeFornecidoEditado){
				new VendaControler().diminuirEstoque(p.getId(), fornecido.getQuantidade() - quantidadeFornecidoEditado);
				comandoFornecido.alterar(fornecido,"Produto fornecido alterado");
				buscaProdutoFornecido();
			}else{
			  Alerta.error("Quantidade é maior do que tem no estoque");
			  return null;
			}
		}else{
			new VendaControler().aumentaEstoque(p.getId(), quantidadeFornecidoEditado - fornecido.getQuantidade() );
			comandoFornecido.alterar(fornecido,"Produto fornecido alterado");
			buscaProdutoFornecido();
		}
			
		return "parcerias.xhtml";
	}
	public String pgProdutoFornecido(){
		quantidadeFornecidoEditado = fornecido.getQuantidade();
		return "configurefornecimento";
	}
	public String addNomeFornecido(){
		fornecido.setNome(produtoSelecionado.getNome());
		return "configurefornecimento";
	}
	public String deletarProdutoFornecido()	{	  	
		
		comandoFornecido.deletar(fornecido,"Fornecimento deletado");		
		buscaProdutoFornecido();		
			
	  return "parcerias.xhtml";
	}
	public void buscaProdutoFornecido(){	
		
		
		listaProdutoFronecido = comandoFornecido.buscaProdutoFornecidos(dataPesquisaFornecido,parceria.getId());	
	  
		if(parceria.getId() == 0)	        	
        	Alerta.warn("Selecione um vendedor para pesquisar");
	    if(listaProdutoFronecido.isEmpty() && parceria.getId() != 0)
        	Alerta.warn("Nada foi encontrado nda  nessa data");
	}
	
	public List getListaParceria() {
		return listaParceria;
	}
	public void setListaParceria(List listaParceria) {
		this.listaParceria = listaParceria;
	}
	public List getlistaContrato() {
		if(parceria.getId() != 0)
			listaContrato = comandoContrato.buscaContratos(parceria.getId());
		else
			listaContrato.clear();
		return listaContrato;
	}
	public void setlistaContrato(List listaContrato) {
		this.listaContrato = listaContrato;
	}
	public Parceria getParceria() {
		return parceria;
	}
	public void setParceria(Parceria parceria) {
		this.parceria = parceria;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	public List getListaProdutoFronecido() {
		return listaProdutoFronecido;
	}
	public void setListaProdutoFronecido(List listaProdutoFronecido) {
		this.listaProdutoFronecido = listaProdutoFronecido;
	}
	public Produto getP() {
		return p;
	}
	public void setP(Produto p) {
		this.p = p;
	}
	public ProdutoFornecido getFornecido() {
		return fornecido;
	}
	public void setFornecido(ProdutoFornecido fornecido) {
		this.fornecido = fornecido;
	}	
	public int getQuantidadeFornecido() {
		return quantidadeFornecido;
	}
	public void setQuantidadeFornecido(int quantidadeFornecido) {
		this.quantidadeFornecido = quantidadeFornecido;
	}
	public String getDataContaFornecido() {
		return dataContaFornecido;
	}
	public void setDataContaFornecido(String dataContaFornecido) {
		this.dataContaFornecido = dataContaFornecido;
	}
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	public String getDataPesquisaFornecido() {
		return dataPesquisaFornecido;
	}
	public void setDataPesquisaFornecido(String dataPesquisaFornecido) {
		this.dataPesquisaFornecido = dataPesquisaFornecido;
	}
	
	
}
