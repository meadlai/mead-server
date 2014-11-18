package com.meadidea.java.server.loader;

/**
 * 
 * @author meadlai
 *
 */
public interface Reloader {
	//
    public void addRepository(String repository);
    //
    public String[] findRepositories();
    //
    public boolean modified();

}
