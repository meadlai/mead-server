package com.meadidea.java.server.lifecycle;

/**
 * 
 * 
 * @author meadlai
 *
 */
public interface Lifecycle {
	

    public void addLifecycleListener(LifecycleListener listener);

    public LifecycleListener[] findLifecycleListeners();

    public void removeLifecycleListener(LifecycleListener listener);
    
	void start() throws LifecycleException;
	void stop() throws LifecycleException;;
}
