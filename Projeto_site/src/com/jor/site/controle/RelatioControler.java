package com.jor.site.controle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jor.site.entidade.Cliente;
import com.jor.site.entidade.Produto;
import com.jor.site.util.HibernateUtil;

public class RelatioControler {
	 Calendar cal = Calendar.getInstance(); 
	 List<Produto> listaDataProduto= new ArrayList<Produto>();
	 List<Cliente> listaDataCliente= new ArrayList<Cliente>();
	 private int janeiro = 0,fevereiro =0,marco = 0,abril =0,maio = 0,junho = 0,
			 julho=0,agosto=0,setembro =0,outubro = 0,novembro =0,dezembro =0;
	 private int janeiro2 = 0,fevereiro2 =0,marco2 = 0,abril2 =0,maio2 = 0,junho2 = 0,
			 julho2=0,agosto2=0,setembro2 =0,outubro2 = 0,novembro2 =0,dezembro2 =0;
	 private Session session;	
	 Date date = null;
	 
	 
	 public void relatorioCliente()
	 {
		 try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		        Query q = session.createQuery ("from Cliente");
		        listaDataCliente =  q.list();
		    } catch (Exception e) {
		         System.out.println("erro ao pesquisar "+e.getMessage());
		    }	 	 		 		 
		 mesesCliente(listaDataCliente);
	 }
	 public void relatorioProduto()
	 {
		 try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		        Query q = session.createQuery ("from Produto");
		        listaDataProduto = q.list();
		    } catch (Exception e) {
		         System.out.println("erro ao pesquisar p "+e.getMessage());
		    }	 	 		 		 
		 mesesProduto(listaDataProduto);
	 }
	 
	 
	 
	 
	 public void mesesProduto(List<Produto> li) {
		
		for(int i = 0;i< listaDataProduto.size();i++)
		{
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            try {
				date = (java.util.Date)formatter.parse((String) li.get(i).getDataCadastro());
				relatorioMeses();
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		}
		
	}
	 public void mesesCliente(List<Cliente> li) {
			
			for(int i = 0;i< listaDataCliente.size();i++)
			{
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	            try {
					date = (java.util.Date)formatter.parse((String) li.get(i).getDataCadastro());
					relatorioMeses2();
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				
			}		 
		}
	 public void relatorioMeses(){
		 cal.setTime(date);
			System.out.println(cal.get(Calendar.MONTH) );
			if(cal.get(Calendar.MONTH) == 0)
			    janeiro++;
			if(cal.get(Calendar.MONTH) == 1)
			    fevereiro++;
			if(cal.get(Calendar.MONTH) == 2)
			    marco++;
			if(cal.get(Calendar.MONTH) == 3)
			    abril++;
			if(cal.get(Calendar.MONTH) == 4)
			    maio++;
			if(cal.get(Calendar.MONTH) == 5)
			    junho++;
			if(cal.get(Calendar.MONTH) == 6)
			    julho++;
			if(cal.get(Calendar.MONTH) == 7)
			    agosto++;
			if(cal.get(Calendar.MONTH) == 8)
			    setembro++;
			if(cal.get(Calendar.MONTH) == 9)
			    outubro++;
			if(cal.get(Calendar.MONTH) == 10)
			    novembro++;
			if(cal.get(Calendar.MONTH) == 11)
			    dezembro++;
	 }
	 public void relatorioMeses2(){
		 cal.setTime(date);
			System.out.println(cal.get(Calendar.MONTH) );
			if(cal.get(Calendar.MONTH) == 0)
			    janeiro2++;
			if(cal.get(Calendar.MONTH) == 1)
			    fevereiro2++;
			if(cal.get(Calendar.MONTH) == 2)
			    marco2++;
			if(cal.get(Calendar.MONTH) == 3)
			    abril2++;
			if(cal.get(Calendar.MONTH) == 4)
			    maio2++;
			if(cal.get(Calendar.MONTH) == 5)
			    junho2++;
			if(cal.get(Calendar.MONTH) == 6)
			    julho2++;
			if(cal.get(Calendar.MONTH) == 7)
			    agosto2++;
			if(cal.get(Calendar.MONTH) == 8)
			    setembro2++;
			if(cal.get(Calendar.MONTH) == 9)
			    outubro2++;
			if(cal.get(Calendar.MONTH) == 10)
			    novembro2++;
			if(cal.get(Calendar.MONTH) == 11)
			    dezembro2++;
	 }
	 
	public int getJaneiro() {
		return janeiro;
	}
	public void setJaneiro(int janeiro) {
		this.janeiro = janeiro;
	}
	public int getFevereiro() {
		return fevereiro;
	}
	public void setFevereiro(int fevereiro) {
		this.fevereiro = fevereiro;
	}
	public int getMarco() {
		return marco;
	}
	public void setMarco(int marco) {
		this.marco = marco;
	}
	public int getAbril() {
		return abril;
	}
	public void setAbril(int abril) {
		this.abril = abril;
	}
	public int getMaio() {
		return maio;
	}
	public void setMaio(int maio) {
		this.maio = maio;
	}
	public int getJunho() {
		return junho;
	}
	public void setJunho(int junho) {
		this.junho = junho;
	}
	public int getJulho() {
		return julho;
	}
	public void setJulho(int julho) {
		this.julho = julho;
	}
	public int getAgosto() {
		return agosto;
	}
	public void setAgosto(int agosto) {
		this.agosto = agosto;
	}
	public int getSetembro() {
		return setembro;
	}
	public void setSetembro(int setembro) {
		this.setembro = setembro;
	}
	public int getOutubro() {
		return outubro;
	}
	public void setOutubro(int outubro) {
		this.outubro = outubro;
	}
	public int getNovembro() {
		return novembro;
	}
	public void setNovembro(int novembro) {
		this.novembro = novembro;
	}
	public int getDezembro() {
		return dezembro;
	}
	public void setDezembro(int dezembro) {
		this.dezembro = dezembro;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Calendar getCal() {
		return cal;
	}
	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	public List<Produto> getListaDataProduto() {
		return listaDataProduto;
	}
	public void setListaDataProduto(List<Produto> listaDataProduto) {
		this.listaDataProduto = listaDataProduto;
	}
	public List<Cliente> getListaDataCliente() {
		return listaDataCliente;
	}
	public void setListaDataCliente(List<Cliente> listaDataCliente) {
		this.listaDataCliente = listaDataCliente;
	}
	public int getJaneiro2() {
		return janeiro2;
	}
	public void setJaneiro2(int janeiro2) {
		this.janeiro2 = janeiro2;
	}
	public int getFevereiro2() {
		return fevereiro2;
	}
	public void setFevereiro2(int fevereiro2) {
		this.fevereiro2 = fevereiro2;
	}
	public int getMarco2() {
		return marco2;
	}
	public void setMarco2(int marco2) {
		this.marco2 = marco2;
	}
	public int getAbril2() {
		return abril2;
	}
	public void setAbril2(int abril2) {
		this.abril2 = abril2;
	}
	public int getMaio2() {
		return maio2;
	}
	public void setMaio2(int maio2) {
		this.maio2 = maio2;
	}
	public int getJunho2() {
		return junho2;
	}
	public void setJunho2(int junho2) {
		this.junho2 = junho2;
	}
	public int getJulho2() {
		return julho2;
	}
	public void setJulho2(int julho2) {
		this.julho2 = julho2;
	}
	public int getAgosto2() {
		return agosto2;
	}
	public void setAgosto2(int agosto2) {
		this.agosto2 = agosto2;
	}
	public int getSetembro2() {
		return setembro2;
	}
	public void setSetembro2(int setembro2) {
		this.setembro2 = setembro2;
	}
	public int getOutubro2() {
		return outubro2;
	}
	public void setOutubro2(int outubro2) {
		this.outubro2 = outubro2;
	}
	public int getNovembro2() {
		return novembro2;
	}
	public void setNovembro2(int novembro2) {
		this.novembro2 = novembro2;
	}
	public int getDezembro2() {
		return dezembro2;
	}
	public void setDezembro2(int dezembro2) {
		this.dezembro2 = dezembro2;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	 
	 
}
