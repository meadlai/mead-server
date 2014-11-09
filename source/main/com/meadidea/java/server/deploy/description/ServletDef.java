package com.meadidea.java.server.deploy.description;

import java.util.HashMap;

//web.xml, Servlets definition.
public final class ServletDef {
	private String servlet_name;
	private String servlet_class;
	private String jsp_file;
	private String servlet_description;
	private int load_on_startup;//order to startup.
	private final HashMap<String,String> init_param = new HashMap<String,String>();
	public String getServlet_name() {
		return servlet_name;
	}
	public void setServlet_name(String servlet_name) {
		this.servlet_name = servlet_name;
	}
	public String getServlet_class() {
		return servlet_class;
	}
	public void setServlet_class(String servlet_class) {
		this.servlet_class = servlet_class;
	}
	
	public String getJsp_file() {
		return jsp_file;
	}
	public void setJsp_file(String jsp_file) {
		this.jsp_file = jsp_file;
	}
	public String getServlet_description() {
		return servlet_description;
	}
	public void setServlet_description(String servlet_description) {
		this.servlet_description = servlet_description;
	}
	
	public void addInitParam(String paramName,String paramValue){
		this.init_param.put(paramName, paramValue);
	}
	public int getLoad_on_startup() {
		return load_on_startup;
	}
	public void setLoad_on_startup(int load_on_startup) {
		this.load_on_startup = load_on_startup;
	}
	
	
	

}
