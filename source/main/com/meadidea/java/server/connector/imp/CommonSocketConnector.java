/**
 * 
 */
package com.meadidea.java.server.connector.imp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

import com.meadidea.java.server.connector.Connector;
import com.meadidea.java.server.lifecycle.LifecycleException;
import com.meadidea.java.server.lifecycle.LifecycleListener;


/**
 * 
 * @author meadlai
 *
 */
public class CommonSocketConnector implements Connector {
	private ServerSocket serverSocket = null;
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
	      try {
			serverSocket =  new ServerSocket(80, 1, InetAddress.getByName("127.0.0.1"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void stop() throws LifecycleException {
		
	}


	
}
