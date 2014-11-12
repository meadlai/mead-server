package com.meadidea.java.server.deploy.description;

//JNDI Environment Variables
//web.xml 
public final class EnvEntryDef {
	private String env_entry_name;
	private String env_entry_value;
	private String env_entry_type;
	private String description;
	public String getEnv_entry_name() {
		return env_entry_name;
	}
	public void setEnv_entry_name(String env_entry_name) {
		this.env_entry_name = env_entry_name;
	}
	public String getEnv_entry_value() {
		return env_entry_value;
	}
	public void setEnv_entry_value(String env_entry_value) {
		this.env_entry_value = env_entry_value;
	}
	public String getEnv_entry_type() {
		return env_entry_type;
	}
	public void setEnv_entry_type(String env_entry_type) {
		this.env_entry_type = env_entry_type;
	}
	//
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
