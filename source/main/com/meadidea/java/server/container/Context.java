package com.meadidea.java.server.container;

import javax.servlet.ServletContext;

public interface Context {
	
	public boolean getAvailable();

	public void setAvailable(boolean available);
	
	public void setContainer(Container container);
	
	public Container getContainer();

	public boolean getCookies();

	public void setCookies(boolean cookies);

	public String getDocBase();

	public void setDocBase(String docBase);

	public String getPath();

	public void setPath(String path);

	public boolean getReloadable();

	public void setReloadable(boolean reloadable);

	public boolean getOverride();

	public void setOverride(boolean override);

	public boolean getPrivileged();

	public void setPrivileged(boolean privileged);

	public ServletContext getServletContext();

	public int getSessionTimeout();

	public void setSessionTimeout(int timeout);

	public String getWrapperClass();

	public void setWrapperClass(String wrapperClass);

	public void addServletMapping(String pattern, String name);

	public void addTaglib(String uri, String location);

	public void addWelcomeFile(String name);

	public String findServletMapping(String pattern);

	public String[] findServletMappings();

	public void reload();

}
