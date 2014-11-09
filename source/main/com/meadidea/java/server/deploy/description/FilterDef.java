package com.meadidea.java.server.deploy.description;

import java.util.HashMap;

public final class FilterDef {
	private String filter_name;
	private String filter_class;
	private final HashMap<String,String> init_param = new HashMap<String,String>();
	public String getFilter_name() {
		return filter_name;
	}
	public void setFilter_name(String filter_name) {
		this.filter_name = filter_name;
	}
	public String getFilter_class() {
		return filter_class;
	}
	public void setFilter_class(String filter_class) {
		this.filter_class = filter_class;
	}
	
	public void addInitParam(String paramName,String paramValue){
		this.init_param.put(paramName, paramValue);
	}
}
