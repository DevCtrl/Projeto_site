package com.jor.site.modelo;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.jor.site.controle.Control_cliente;
import com.jor.site.entidade.Cliente;

@ManagedBean(name="benCliente")
@SessionScoped
public class Ben_cliente {
   
	private Cliente cliente = new Cliente();
	Cliente clienteSelecionado;
	Control_cliente comando = new Control_cliente();
	List lista = new ArrayList();
	
	public Ben_cliente()
	{
		lista =  comando.Listar_Dados();
	}
	
	
	public String  Incluir()
	{
		System.out.println("  teste te "+cliente.getId());
		if(cliente.getId() == 0){			
			comando.inserir(cliente);			
		}
		else{			
			comando.alterar(cliente);	
		}		
		lista = comando.Listar_Dados();
		cliente = new Cliente();
		return "Cliente.xhtml";
	}
	public String  Edita()	{		
		System.out.println("metodo chamdo link");
		return "ConfigureCliente.xhtml";				
	}
	public String  Cadastro()	{
		cliente = new Cliente();
		return "ConfigureCliente.xhtml";					
	}
	public String Deletar()
	{
		System.out.println(cliente.getNome());
		comando.deletar(cliente);		
		lista = comando.Listar_Dados();
		cliente = new Cliente();
		return "Cliente.xhtml";
	}
	public String BuscaCli()
	{
		System.out.println(cliente.getNome());
		lista = comando.BuscaClientes(cliente.getNome());
		return "null";
	}

	public Cliente getcliente() {
		return cliente;
	}

	public void setcliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List getLista() {
		return lista ;
	}

	public void setLista(List lista) {
		this.lista = lista;
	}
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}
	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
}
