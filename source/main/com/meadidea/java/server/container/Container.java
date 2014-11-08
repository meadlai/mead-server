package com.meadidea.java.server.container;

import java.io.IOException;

import javax.servlet.ServletException;

import com.meadidea.java.server.http.HttpRequest;
import com.meadidea.java.server.http.HttpResponse;

public interface Container {
	
	public void addChild(Container child);

	public void removeChild(Container child);

	public Container findChild(String name);

	public Container[] findChildren();
	
    public void invoke(HttpRequest request, HttpResponse response)
            throws IOException, ServletException;
}
