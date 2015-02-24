package com.jor.site.modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="benSite")
@SessionScoped
public class SiteBen {

	private String section1 ="meu texto sendo editado neste momento";
	
	public void edite(){
		this.section1 = getSection1();
	}

	public String getSection1() {
		return section1;
	}

	public void setSection1(String section1) {
		this.section1 = section1;
	}
	
	
}
