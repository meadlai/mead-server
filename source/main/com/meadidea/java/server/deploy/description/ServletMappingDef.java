package com.meadidea.java.server.deploy.description;

//web.xml, servlet-mapping elements.
public final class ServletMappingDef {
	
	private String servlet_name;
	private String url_pattern;
	public String getServlet_name() {
		return servlet_name;
	}
	public void setServlet_name(String servlet_name) {
		this.servlet_name = servlet_name;
	}
	public String getUrl_pattern() {
		return url_pattern;
	}
	public void setUrl_pattern(String url_pattern) {
		this.url_pattern = url_pattern;
	}
	
}
