package com.meadidea.java.server.loader;

import java.beans.PropertyChangeListener;

import com.meadidea.java.server.container.Container;

public interface Loader {
	//
    public boolean modified();
    //
    public ClassLoader getClassLoader();

    //
    public boolean getDelegate();
    public void setDelegate(boolean delegate);
    //
    public String getInfo();
    //
    public boolean getReloadable();
    public void setReloadable(boolean reloadable);

    //
    public void addPropertyChangeListener(PropertyChangeListener listener);
    public void removePropertyChangeListener(PropertyChangeListener listener);

    //
    public String[] findRepositories();
    public void addRepository(String repository);
    //
    public Container getContainer();
    public void setContainer(Container container);

}
