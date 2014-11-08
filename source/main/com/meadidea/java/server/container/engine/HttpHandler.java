package com.meadidea.java.server.container.engine;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.meadidea.java.server.container.Container;
import com.meadidea.java.server.container.wrapper.WrapperDispatcher;
import com.meadidea.java.server.http.HttpRequest;
import com.meadidea.java.server.http.HttpResponse;



/**
 * 
 * @author meadlai
 *
 */
public class HttpHandler {
	private HttpRequest request;
	private HttpResponse response;
	private Container rootContainer;

	
public HttpHandler(Socket skt){
	//this.socket = skt;
	this.rootContainer = new BasicEngine();
}

public void process(Socket socket) {
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
      
      
//      WrapperDispatcher dispatcher = new WrapperDispatcher();
//      dispatcher.process(request, response);

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
  }


}
