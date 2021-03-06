package com.meadidea.java.server.container.wrapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import com.meadidea.java.server.container.Wrapper;
import com.meadidea.java.server.deploy.description.ServletDef;
import com.meadidea.java.server.http.HttpRequest;
import com.meadidea.java.server.http.HttpResponse;

public class ServletWrapper implements Wrapper{
	//
	private ServletDef servletDefine;

	@Override
	public void process(HttpRequest request, HttpResponse response) {
		 String uri = request.getRequestURI();
		    String servletName = "webapp"+File.separator+ "servlet" + File.separator + uri.substring(uri.lastIndexOf("/") + 1);
		    URLClassLoader loader = null;
		    servletName = "webapp.servlet.Test";

		    try {
		      // create a URLClassLoader
		      URL[] urls = new URL[1];
		      URLStreamHandler streamHandler = null;
		      File classPath = new File(Constants.WEB_ROOT);
		      // the forming of repository is taken from the createClassLoader method in
		      // org.apache.catalina.startup.ClassLoaderFactory
		      String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator) ).toString() ;
		      // the code for forming the URL is taken from the addRepository method in
		      // org.apache.catalina.loader.StandardClassLoader class.
		      System.out.println("repository="+repository);
		      System.out.println("servletName="+servletName);

		      urls[0] = new URL(null, repository, streamHandler);
		      loader = new URLClassLoader(urls);
		    }
		    catch (IOException e) {
		      System.out.println(e.toString() );
		    }
		    Class<?> myClass = null;
		    try {
		      myClass = loader.loadClass(servletName);
		    }
		    catch (ClassNotFoundException e) {
		      System.out.println(e.toString());
		    }

		    HttpServlet servlet = null;

		    try {
		      servlet = (HttpServlet) myClass.newInstance();
		      servlet.init();
		      servlet.service((ServletRequest) request, (ServletResponse) response);
		    }
		    catch (Exception e) {
		      System.out.println(e.toString());
		    }
		    catch (Throwable e) {
		      System.out.println(e.toString());
		    }

	}

}
