/**
 * 
 */
package com.meadidea.java.server;

import com.meadidea.java.server.lifecycle.LifecycleException;

/**
 * @author meadlai
 *
 */
public class Start {

	/**
	 * @param args
	 * @throws LifecycleException 
	 */
	public static void main(String[] args) throws LifecycleException {

		HttpSever server = new HttpSever();
		server.start();
		
	}

}
