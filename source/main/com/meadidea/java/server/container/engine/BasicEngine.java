/**
 * 
 */
package com.meadidea.java.server.container.engine;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;

import com.meadidea.java.server.container.Container;
import com.meadidea.java.server.container.Engine;
import com.meadidea.java.server.container.Host;
import com.meadidea.java.server.container.host.BasicHost;
import com.meadidea.java.server.http.HttpRequest;
import com.meadidea.java.server.http.HttpResponse;


/**
 * 
 * @author meadlai
 *
 */
public class BasicEngine implements Container,Engine{
	private HashMap<String,Host> hostMap = new HashMap<String,Host>();
	private Container defaultHost =null;

	public BasicEngine(){
		defaultHost = new BasicHost();
	}
	
	@Override
	public void addChild(Container child) {
		
	}

	@Override
	public void removeChild(Container child) {
		
	}

	@Override
	public Container findChild(String name) {
		return null;
	}

	@Override
	public Container[] findChildren() {
		return null;
	}

	@Override
	public String getDefaultHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDefaultHost(String defaultHost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void invoke(HttpRequest request, HttpResponse response)
			throws IOException, ServletException {
		defaultHost.invoke(request, response);
	}

	


}
