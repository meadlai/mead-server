package com.meadidea.java.server.deploy.description;

//web.xml context-param definition
public class ContextParamDef {
	private String description;
	private String param_name;
	private String param_value;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParam_name() {
		return param_name;
	}
	public void setParam_name(String param_name) {
		this.param_name = param_name;
	}
	public String getParam_value() {
		return param_value;
	}
	public void setParam_value(String param_value) {
		this.param_value = param_value;
	}
	
}
