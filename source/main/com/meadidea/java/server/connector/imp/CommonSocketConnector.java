/**
 * 
 */
package com.meadidea.java.server.connector.imp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.meadidea.java.server.connector.Connector;
import com.meadidea.java.server.lifecycle.LifecycleException;
import com.meadidea.java.server.lifecycle.LifecycleListener;

/**
 * 
 * @author meadlai
 *
 */
public class CommonSocketConnector implements Connector, Runnable {
	private ServerSocket serverSocket = null;
	private boolean started = false;
	private boolean stopped = false;
	private Thread thread = null;

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
			serverSocket = new ServerSocket(80, 1,
					InetAddress.getByName("127.0.0.1"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.thread = new Thread(this, "");
		this.thread.setDaemon(true);
		this.thread.start();
		
	}

	@Override
	public void stop() throws LifecycleException {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		Socket socket = null;
		try {
			socket =  serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
