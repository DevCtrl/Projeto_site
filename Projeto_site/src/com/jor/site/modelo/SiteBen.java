package com.jor.site.modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.jor.site.controle.SiteControler;
import com.jor.site.entidade.Site;

@ManagedBean(name="benSite")
@RequestScoped
public class SiteBen {
    Site site = new Site();
    SiteControler comando = new SiteControler();
	public SiteBen()
	{
		site = (Site) comando.buscaSite();
	}
	
	public void salvar(){
		site.setId(1);
		if(site.getVideo1().length() < 20 )
			site.setVideo1("http://www.youtube.com/embed/"+site.getVideo1()+"?feature=player_detailpage");
		if(site.getVideo2().length() < 20 )
			site.setVideo2("http://www.youtube.com/embed/"+site.getVideo2()+"?feature=player_detailpage");
		if(site.getVideo3().length() < 20 )
			site.setVideo3("http://www.youtube.com/embed/"+site.getVideo3()+"?feature=player_detailpage");
		
		
		comando.incluir(site);
		
	}


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}	

	
	
}
