package com.meadidea.java.server.deploy;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestDeploy {

	public static void main(String[] args) throws Exception {
		TestDeploy deploy = new TestDeploy();
		deploy.testWebXMLRead();
	}

	public void testWebXMLRead() throws DocumentException {
		SAXReader saxReader = new SAXReader();
		String path = this.getClass().getResource("").getPath();
		System.out.println(path);
		File file = new File(path + "web.xml");
		Document document = saxReader.read(file);

		//get root element
		Element webapp = document.getRootElement();
		String webappVersion = webapp.attributeValue("version");
		System.out.println("webappVersion = " + webappVersion);
		Element displayName = webapp.element("display-name");
		System.out.println("displayName = " + displayName.getTextTrim());
		Element description = webapp.element("description");
		System.out.println("description = " + description.getTextTrim());

		// session_timeout
		Element sessionConfig = webapp.element("session-config");
		if (sessionConfig != null) {
			Element sessionTimeout = sessionConfig.element("session-timeout");
			System.out.println("sessionTimeout = " + sessionTimeout.getTextTrim());
		}

		// context_param
		@SuppressWarnings("unchecked")
		Iterator<Element> contextParams = webapp.elements("context-param")
				.iterator();
		if (contextParams != null) {
			while (contextParams.hasNext()) {
				System.out.println("!!!!");
				Element contextParam = contextParams.next();
				Element paramName = contextParam.element("param-name");
				System.out.println(paramName.getName() + ":"
						+ paramName.getTextTrim());
				Element paramValue = contextParam.element("param-value");
				System.out.println(paramValue.getName() + ":"
						+ paramValue.getTextTrim());
				Element paramDescription = contextParam.element("description");
				if (paramDescription != null) {
					System.out.println(paramDescription.getName() + ":"
							+ paramDescription.getTextTrim());
				}
			}
		}

		// env-entry
		@SuppressWarnings("unchecked")
		Iterator<Element> envEntrys = webapp.elements("env-entry").iterator();
		if (envEntrys != null) {
			while (envEntrys.hasNext()) {
				System.out.println("!!!!");
				Element envEntry = envEntrys.next();
				Element envName = envEntry.element("env-entry-name");
				System.out.println(envName.getName() + ":" + envName.getTextTrim());
				Element envValue = envEntry.element("env-entry-value");
				System.out.println(envValue.getName() + ":"
						+ envValue.getTextTrim());
				Element envType = envEntry.element("env-entry-type");
				System.out.println(envType.getName() + ":" + envType.getTextTrim());
				Element envDescription = envType.element("description");
				if (envDescription != null) {
					System.out.println(envDescription.getName() + ":"
							+ envDescription.getTextTrim());
				}
			}
		}
		// servlet
		@SuppressWarnings("unchecked")
		Iterator<Element> servlets = webapp.elements("servlet").iterator();
		while (servlets.hasNext()) {
			System.out.println("####");
			Element servlet = servlets.next();
			Element servletName = servlet.element("servlet-name");
			System.out.println(servletName.getName() + ":"
					+ servletName.getTextTrim());
			Element servletClass = servlet.element("servlet-class");
			System.out.println(servletClass.getName() + ":"
					+ servletClass.getTextTrim());
			Element loadonStartup = servlet.element("load-on-startup");
			System.out.println(loadonStartup.getName() + ":"
					+ loadonStartup.getTextTrim());
			// init-param
			@SuppressWarnings("unchecked")
			Iterator<Element> initParms = servlet.elements("init-param")
					.iterator();
			while (initParms.hasNext()) {
				Element initParm = initParms.next();
				Element paramName = initParm.element("param-name");
				System.out.println(paramName.getName() + ":"
						+ paramName.getTextTrim());
				Element paramValue = initParm.element("param-value");
				System.out.println(paramValue.getName() + ":"
						+ paramValue.getTextTrim());
			}
		}

		// servlet-mapping
		@SuppressWarnings("unchecked")
		Iterator<Element> servletMappings = webapp.elements("servlet-mapping").iterator();
		while (servletMappings.hasNext()) {
			System.out.println("%%%%");
			Element servletMapping = servletMappings.next();
			Element servletName = servletMapping.element("servlet-name");
			System.out.println(servletName.getName() + ":"
					+ servletName.getTextTrim());
			Element urlPattern = servletMapping.element("url-pattern");
			System.out.println(urlPattern.getName() + ":"
					+ urlPattern.getTextTrim());
		}
		// filter
		@SuppressWarnings("unchecked")
		Iterator<Element> filters = webapp.elements("filter").iterator();
		while (filters.hasNext()) {
			System.out.println("&&&&");
			Element filter = filters.next();
			Element filterName = filter.element("filter-name");
			System.out.println(filterName.getName() + ":"
					+ filterName.getTextTrim());
			Element filterClass = filter.element("filter-class");
			System.out.println(filterClass.getName() + ":"
					+ filterClass.getTextTrim());
			
			// init-param
			@SuppressWarnings("unchecked")
			Iterator<Element> initParms = filter.elements("init-param")
					.iterator();
			while (initParms.hasNext()) {
				Element initParm = initParms.next();
				Element paramName = initParm.element("param-name");
				System.out.println(paramName.getName() + ":"
						+ paramName.getTextTrim());
				Element paramValue = initParm.element("param-value");
				System.out.println(paramValue.getName() + ":"
						+ paramValue.getTextTrim());
			}
		}
		
		// filter-mapping
		@SuppressWarnings("unchecked")
		Iterator<Element> filterMappings = webapp.elements("filter-mapping").iterator();
		while (filterMappings.hasNext()) {
			System.out.println("~~~~");
			Element filterMapping = filterMappings.next();
			Element filterName = filterMapping.element("filter-name");
			System.out.println(filterName.getName() + ":"
					+ filterName.getTextTrim());
			Element urlPattern = filterMapping.element("url-pattern");
			System.out.println(urlPattern.getName() + ":"
					+ urlPattern.getTextTrim());
		}
		
		// listener
		System.out.println("^^^^^");
		@SuppressWarnings("unchecked")
		Iterator<Element> listeners = webapp.elements("listener").iterator();
		while (listeners.hasNext()) {
			Element listener = listeners.next();
			Element listenerClass = listener.element("listener-class");
			System.out.println("listenerClass = " + listenerClass.getTextTrim());
		}
	}

}
