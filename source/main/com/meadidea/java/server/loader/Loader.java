package com.meadidea.java.server.loader;

import java.beans.PropertyChangeListener;

public interface Loader {
	//
    public boolean modified();
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

}
