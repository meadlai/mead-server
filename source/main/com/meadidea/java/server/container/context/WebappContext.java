package com.meadidea.java.server.container.context;

import java.io.File;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.dom4j.DocumentException;

import com.meadidea.java.server.container.Container;
import com.meadidea.java.server.container.Context;
import com.meadidea.java.server.deploy.TestDeploy;
import com.meadidea.java.server.deploy.description.WebappDef2_4;
import com.meadidea.java.server.lifecycle.Lifecycle;
import com.meadidea.java.server.lifecycle.LifecycleException;
import com.meadidea.java.server.lifecycle.LifecycleListener;
import com.meadidea.java.server.loader.imp.WebAppLoader;

public class WebappContext implements Context,Lifecycle{
	//was it startup fine...
	private boolean available = false;
	private HashMap servletMappings = new HashMap();
	//wep-path,web.xml,classes,lib.
	private String path;
	private String docBase;
	private String webxmlPath;
	private WebappDef2_4 webXmlDefine;

	//
	private WebAppLoader webappLoader;
	
	public WebappContext(String path){
		this.path = path;
		if(this.validateWebapp()==false){
			throw new RuntimeException("Can't init Webapp:" + path);
		}
	}
	
	private boolean validateWebapp(){
		//1,is file there?
		//2,is web.xml ok?
		File file = new File(path);
		if(file.exists() && file.isDirectory()){
			//pass
		}else{
			return false;
		}
		//
		this.webxmlPath = path + "WEB-INF\\web.xml";
		file = new File(this.webxmlPath);
		if(file.exists() && file.isFile()){
			//pass
		}else{
			return false;
		}
		
		//
		try {
			this.webXmlDefine = new TestDeploy().buildWebappDef(this.webxmlPath);
			return true;
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean getAvailable() {
		return this.available;
	}

	@Override
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	@Override
	public void setContainer(Container container) {
		
	}

	@Override
	public Container getContainer() {
		return null;
	}

	@Override
	public boolean getCookies() {
		return false;
	}

	@Override
	public void setCookies(boolean cookies) {
		
	}

	@Override
	public String getDocBase() {
		return this.docBase;
	}

	@Override
	public void setDocBase(String docBase) {
		this.docBase = docBase;
	}

	@Override
	public String getPath() {
		return this.path;
	}

	@Override
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public boolean getReloadable() {
		return false;
	}

	@Override
	public void setReloadable(boolean reloadable) {
		
	}

	@Override
	public boolean getOverride() {
		return false;
	}

	@Override
	public void setOverride(boolean override) {
		
	}

	@Override
	public boolean getPrivileged() {
		return false;
	}

	@Override
	public void setPrivileged(boolean privileged) {
		
	}

	@Override
	public ServletContext getServletContext() {
		return null;
	}

	@Override
	public int getSessionTimeout() {
		return 0;
	}

	@Override
	public void setSessionTimeout(int timeout) {
		
	}

	@Override
	public String getWrapperClass() {
		return null;
	}

	@Override
	public void setWrapperClass(String wrapperClass) {
		
	}

	@Override
	public void addServletMapping(String pattern, String name) {
		
	}

	@Override
	public void addTaglib(String uri, String location) {
		
	}

	@Override
	public void addWelcomeFile(String name) {
		
	}

	@Override
	public String findServletMapping(String pattern) {
		return null;
	}

	@Override
	public String[] findServletMappings() {
		return null;
	}

	@Override
	public void reload() {

	}

	//life-cycle implements... 
	@Override
	public void addLifecycleListener(LifecycleListener listener) {
		
	}

	@Override
	public LifecycleListener[] findLifecycleListeners() {
		return null;
	}

	@Override
	public void removeLifecycleListener(LifecycleListener listener) {
		
	}

	@Override
	public void start() throws LifecycleException {
		
	}

	@Override
	public void stop() throws LifecycleException {
		
	}

}
