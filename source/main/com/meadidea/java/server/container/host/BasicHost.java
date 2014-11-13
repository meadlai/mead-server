package com.meadidea.java.server.container.host;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;

import com.meadidea.java.server.container.Container;
import com.meadidea.java.server.container.Host;
import com.meadidea.java.server.container.wrapper.WrapperDispatcher;
import com.meadidea.java.server.deploy.description.WebappDef2_4;
import com.meadidea.java.server.http.HttpRequest;
import com.meadidea.java.server.http.HttpResponse;

/**
 * 
 * @author meadlai
 *
 */
public class BasicHost implements Container,Host {
	private WebappDef2_4 webappDefine;
	
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
	public void invoke(HttpRequest request, HttpResponse response)
			throws IOException, ServletException {
		 WrapperDispatcher dispatcher = new WrapperDispatcher();
	      dispatcher.process(request, response);		
	}

}
