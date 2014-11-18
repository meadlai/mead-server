package com.meadidea.java.server.loader.imp;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.meadidea.java.server.loader.Loader;

public class WebAppLoader implements Loader,PropertyChangeListener{
	//
    private WebClassLoader classLoader = null;

	//
	public WebAppLoader(){
		super();//parent load me.
	}
	
	@Override
	public boolean modified() {
		return false;
	}

	@Override
	public boolean getDelegate() {
		return false;
	}

	@Override
	public void setDelegate(boolean delegate) {
		
	}

	@Override
	public String getInfo() {
		return "WebAppLoader";
	}

	@Override
	public boolean getReloadable() {
		return false;
	}

	@Override
	public void setReloadable(boolean reloadable) {
		
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		
	}

	

	@Override
	public String[] findRepositories() {
		return null;
	}

	@Override
	public void addRepository(String repository) {
		
	}

	//
	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}
	

}
