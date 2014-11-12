package com.meadidea.java.server.deploy.description;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//web.xml
public final class WebappDef2_4 {
	// http://java.sun.com/xml/ns/j2ee
	// http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd
	public static final String version = "2.4";
	private String display_name;
	private String description;
	private boolean distributable;
	private int session_timeout;

	//
	private List<ContextParamDef> context_param = new ArrayList<ContextParamDef>(
			2);
	private List<EnvEntryDef> env_entry = new ArrayList<EnvEntryDef>(1);
	private List<FilterDef> filter = new ArrayList<FilterDef>(1);
	private List<FilterMappingDef> filter_mapping = new ArrayList<FilterMappingDef>(
			2);
	private List<ServletDef> servlet = new ArrayList<ServletDef>(2);
	private List<ServletMappingDef> servlet_mapping = new ArrayList<ServletMappingDef>(
			2);
	private List<String> listener_class = new ArrayList<String>(1);

	// extension,mime-type,error-page
	private HashMap<String, String> mime_mapping = new HashMap<String, String>();
	private List<String> welcome_file_list = new ArrayList<String>();
	private List<ErrorPageDef> error_page = new ArrayList<ErrorPageDef>();

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDistributable() {
		return distributable;
	}

	public void setDistributable(boolean distributable) {
		this.distributable = distributable;
	}

	public int getSession_timeout() {
		return session_timeout;
	}

	public void setSession_timeout(int session_timeout) {
		this.session_timeout = session_timeout;
	}

	//
	public void addContext_param(ContextParamDef def) {
		this.context_param.add(def);
	}

	public void addEnv_entry(EnvEntryDef def) {
		this.env_entry.add(def);
	}

	public void addFilter(FilterDef def) {
		this.filter.add(def);
	}

	public void addFilter_mapping(FilterMappingDef def) {
		this.filter_mapping.add(def);
	}

	public void addServlet(ServletDef def) {
		this.servlet.add(def);
	}

	public void addServlet_mapping(ServletMappingDef def) {
		this.servlet_mapping.add(def);
	}
	
	public void addListner_class(String listenerClass){
		this.listener_class.add(listenerClass);
	}

	public void addMime_mapping(String extension, String mimeType) {
		this.mime_mapping.put(extension, mimeType);
	}

	public void addWelcome_file_list(String def) {
		this.welcome_file_list.add(def);
	}
	
	public void addError_page(ErrorPageDef def){
		this.error_page.add(def);
	}

}
