/**
 * 
 */
package com.meadidea.java.server.connector.imp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.meadidea.java.server.connector.Connector;
import com.meadidea.java.server.container.Container;
import com.meadidea.java.server.container.engine.HttpHandler;
import com.meadidea.java.server.http.HttpRequest;
import com.meadidea.java.server.http.HttpResponse;
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
	private Container rootContainer;
	//
	private HttpRequest request;
	private HttpResponse response;
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
		this.thread.setDaemon(false);
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
		while (!this.stopped) {
			Socket socket = null;
			HttpHandler handler = null;
			try {
				socket = serverSocket.accept();
				
				InputStream input = null;
			    OutputStream output = null;
			    try {
			      input = socket.getInputStream();
			      output = socket.getOutputStream();

			      // create HttpRequest object and parse
			      request = new HttpRequest(input);

			      // create HttpResponse object
			      response = new HttpResponse(output);
			      response.setRequest(request);
			      this.rootContainer.invoke(request, response);
			      input.close();
			      output.flush();
			      output.close();
			      System.err.println("Serving...");
			      // Close the socket
			      socket.close();
			      // no shutdown for this application
			    }
			    catch (Exception e) {
			      e.printStackTrace();
			    }
			    
//				handler = new HttpHandler(socket);
//				handler.process(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Container getContainer() {
		return this.rootContainer;
	}

	@Override
	public void setContainer(Container container) {
		this.rootContainer = container;
	}

}
