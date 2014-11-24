package com.meadidea.java.server.loader.imp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.jar.JarFile;

import com.meadidea.java.server.loader.Reloader;
import com.sun.xml.internal.ws.util.StringUtils;

/**
 * 
 * @author meadlai
 *
 */
public class WebClassLoader extends URLClassLoader implements Reloader {

	// The parent class loader.
	private ClassLoader parent = null;
	// The system class loader.
	private ClassLoader system = null;
	private SecurityManager securityManager = null;

	//
	protected String repositories[] = new String[0];
	protected int debug = 0;
	private boolean hasExternalRepositories;
	//
	protected HashMap resourceEntries = new HashMap();
	protected HashMap notFoundResources = new HashMap();
	protected boolean delegate = false;
	//
	protected JarFile[] jarFiles = new JarFile[0];
	protected File[] files = new File[0];

	public WebClassLoader() {
		super(new URL[0]);
		this.parent = getParent();
		this.system = getSystemClassLoader();
		this.securityManager = System.getSecurityManager();
	}

	public WebClassLoader(URL[] urls) {
		super(urls);
		this.parent = getParent();
		this.system = getSystemClassLoader();
		this.securityManager = System.getSecurityManager();
	}

	public WebClassLoader(ClassLoader parent) {
		super((new URL[0]), parent);
		this.parent = parent;
		this.system = getSystemClassLoader();
		this.securityManager = System.getSecurityManager();
	}

	public WebClassLoader(String repositories[]) {
		super((new URL[0]));
		this.repositories = repositories;
	}

	public WebClassLoader(String repositories[], ClassLoader parent) {
		super((new URL[0]), parent);
		this.parent = parent;
		this.repositories = repositories;
	}

	public WebClassLoader(URL repositories[], ClassLoader parent) {
		super(repositories, parent);
		this.parent = parent;
		this.system = getSystemClassLoader();
		securityManager = System.getSecurityManager();
	}

	@Override
	public boolean modified() {
		return false;
	}

	@Override
	public String[] findRepositories() {
		return null;
	}

	@Override
	public void addRepository(String repository) {
		this.resolveJarfile(repository);
	}

	private void resolveJarfile(String repository) {
		if (repository != null && repository.contains("WEB-INF\\lib")) {
			// pass
		} else {
			return;
		}
		File lib = new File(repository);
		for (File file : lib.listFiles()) {
			if (file.isFile() && file.getName().endsWith(".jar")) {
				URL url;
				try {
					System.out.println("=" + file.getAbsolutePath());
					String path = "file:" + file.getAbsolutePath();
					url = new URL(path);
					super.addURL(url);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String classNameToPath(String repository, String className) {
		return repository + File.separatorChar
				+ className.replace('.', File.separatorChar) + ".class";
	}

	// TODO: implements
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		System.out.println("###findClass@" + name);
		 Class<?> clazz = super.findClass(name);
		 if(clazz != null ){
			 return clazz;
		 }
		throw new ClassNotFoundException(name);
	}

	// TODO: override it
	public Class<?> loadClass(String name, boolean resolve)
			throws ClassNotFoundException {

		if (debug >= 2)
			log("loadClass(" + name + ", " + resolve + ")");

		Class<?> clazz = null;

		// (0) Check our previously loaded class cache
		clazz = findLoadedClass(name);
		if (clazz != null) {
			if (debug >= 3)
				log("  Returning class from cache");
			if (resolve)
				resolveClass(clazz);
			return (clazz);
		}

		// If a system class, use system class loader
		if (name.startsWith("java.")) {
			ClassLoader loader = system;
			clazz = loader.loadClass(name);
			if (clazz != null) {
				if (resolve)
					resolveClass(clazz);
				return (clazz);
			}
			throw new ClassNotFoundException(name);
		}

		// (.5) Permission to access this class when using a SecurityManager
		if (securityManager != null) {
			int i = name.lastIndexOf('.');
			if (i >= 0) {
				try {
					securityManager.checkPackageAccess(name.substring(0, i));
				} catch (SecurityException se) {
					String error = "Security Violation, attempt to use "
							+ "Restricted Class: " + name;
					System.out.println(error);
					se.printStackTrace();
					log(error);
					throw new ClassNotFoundException(error);
				}
			}
		}

		clazz = this.findClass(name);
		if (clazz != null) {
			return clazz;
		}
		return null;
	}

	private void log(String message) {
		System.out.println("WebClassLoader: " + message);

	}
}
