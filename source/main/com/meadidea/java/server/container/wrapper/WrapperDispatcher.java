package com.meadidea.java.server.container.wrapper;

import com.meadidea.java.server.http.HttpRequest;
import com.meadidea.java.server.http.HttpResponse;

public class WrapperDispatcher implements Wrapper {

	@Override
	public void process(HttpRequest request, HttpResponse response) {
		String url = request.getRequestURI();
		if(url.contains("html")){
			StaticResourceWrapper staticWrapper = new StaticResourceWrapper();
			staticWrapper.process(request, response);
		}
	}
	
}
