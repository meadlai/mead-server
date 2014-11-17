package com.meadidea.java.server.loader.imp;

import java.beans.PropertyChangeListener;

import com.meadidea.java.server.loader.Loader;

public class WebClassLoader extends ClassLoader  implements Loader{

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
		return "WebClassLoader";
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
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		
	}

	@Override
	public String[] findRepositories() {
		return null;
	}

	@Override
	public void addRepository(String repository) {
		
	}
	
	//
    protected Class<?> findClass(String name) throws ClassNotFoundException {
    	//TODO:override it.
        throw new ClassNotFoundException(name);
    }

}
