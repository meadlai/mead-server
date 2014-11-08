package com.meadidea.java.server.container.wrapper;

import com.meadidea.java.server.container.Wrapper;
import com.meadidea.java.server.http.HttpRequest;
import com.meadidea.java.server.http.HttpResponse;

public class WrapperDispatcher implements Wrapper {

	@Override
	public void process(HttpRequest request, HttpResponse response) {
		String url = request.getRequestURI();
		if(url.contains("html")){
			StaticResourceWrapper staticWp = new StaticResourceWrapper();
			staticWp.process(request, response);
		}else if(url.contains("servlet")){
			ServletWrapper servletWp = new ServletWrapper();
			servletWp.process(request, response);
		}else if(url.contains(".jsp")){
			JspWrapper jspWp = new JspWrapper();
			jspWp.process(request, response);
		}
	}
	
}
