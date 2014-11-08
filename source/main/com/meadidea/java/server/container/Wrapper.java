package com.meadidea.java.server.container;

import com.meadidea.java.server.http.HttpRequest;
import com.meadidea.java.server.http.HttpResponse;

public interface Wrapper {
	void process(HttpRequest request,HttpResponse response);
}
