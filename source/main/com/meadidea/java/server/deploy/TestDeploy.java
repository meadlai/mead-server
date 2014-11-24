package com.meadidea.java.server.deploy;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.meadidea.java.server.container.context.WebappContext;
import com.meadidea.java.server.deploy.description.ContextParamDef;
import com.meadidea.java.server.deploy.description.EnvEntryDef;
import com.meadidea.java.server.deploy.description.ErrorPageDef;
import com.meadidea.java.server.deploy.description.FilterDef;
import com.meadidea.java.server.deploy.description.FilterMappingDef;
import com.meadidea.java.server.deploy.description.ServletDef;
import com.meadidea.java.server.deploy.description.ServletMappingDef;
import com.meadidea.java.server.deploy.description.WebappDef2_4;
import com.meadidea.java.server.loader.imp.WebAppLoader;
import com.meadidea.java.server.loader.imp.WebClassLoader;
import com.meadidea.java.server.support.IntegerUtil;

public class TestDeploy {

	public static void main(String[] args) throws Exception {
		TestDeploy deploy = new TestDeploy();
		deploy.testDeploy();
		// deploy.testWebXMLRead();
	}

	public static void printClassloader(Class clazz){
		ClassLoader loader1 = clazz.getClassLoader();
		while (loader1 != null) {
			System.out.println("1######" + loader1.toString());
			loader1 = loader1.getParent();
		}
	}
	/**
	 * path = D:\svn\Sources\Mobile_Front\WebRoot\ xml =
	 * D:\svn\Sources\Mobile_Front\WebRoot\WEB-INF\web.xml lib =
	 * D:\svn\Sources\Mobile_Front\WebRoot\WEB-INF\lib\ cls =
	 * D:\svn\Sources\Mobile_Front\WebRoot\WEB-INF\classes\
	 */
	public void testDeploy() {
		String path = "D:\\svn\\Sources\\Mobile_Front\\WebRoot\\";
		String xml = "D:\\svn\\Sources\\Mobile_Front\\WebRoot\\WEB-INF\\web.xml";
		String lib = "D:\\svn\\Sources\\Mobile_Front\\WebRoot\\WEB-INF\\lib\\";
		String cls = "D:\\svn\\Sources\\Mobile_Front\\WebRoot\\WEB-INF\\classes\\";

		// 1=,prepare a demo webapp
		WebappContext context = new WebappContext(path);
		// 2,set docbase & path
		// 3,read web.xml
		// 4,loader webappContext
		// 5,builder webappLoader
		WebAppLoader apploader = new WebAppLoader();
		WebClassLoader classloader = (WebClassLoader)apploader.getClassLoader();
		//
		
		// 6,builder webclassLoader
		String className = "com.hundsun.fund.mobile.util.StartupServlet";
		className = "javapns.notification.PushNotificationPayload";
		try {
			classloader.addRepository(lib);
			classloader.addRepository(cls);

			Class<?> class1 = classloader.loadClass(className);
			Object obj1 = class1.newInstance();

			Method setSampleMethod = class1.getMethod("addAlert",
					java.lang.String.class);
			setSampleMethod.invoke(obj1,"test");

			// 7,test SERVLET loading
			// 8,test LISTNER loading
			// 9,test context-parameter
			// 0,integrate socket & http into this
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public WebappDef2_4 buildWebappDef(String xmlpath) throws DocumentException {
		WebappDef2_4 webappDef = new WebappDef2_4();

		SAXReader saxReader = new SAXReader();
		File file = new File(xmlpath);
		Document document = saxReader.read(file);

		// get root element
		Element webapp = document.getRootElement();
		String webappVersion = webapp.attributeValue("version");
		System.out.println("webappVersion = " + webappVersion);
		Element displayName = webapp.element("display-name");
		webappDef.setDisplay_name(displayName.getTextTrim());
		System.out.println("displayName = " + displayName.getTextTrim());
		Element description = webapp.element("description");
		if (description != null) {
			webappDef.setDescription(description.getTextTrim());
			System.out.println("description = " + description.getTextTrim());
		}

		// session_timeout
		Element sessionConfig = webapp.element("session-config");
		if (sessionConfig != null) {
			Element sessionTimeout = sessionConfig.element("session-timeout");
			System.out.println("sessionTimeout = "
					+ sessionTimeout.getTextTrim());
			int timeout = IntegerUtil.intFromString(
					sessionTimeout.getTextTrim(), 1200);
			webappDef.setSession_timeout(timeout);
		}

		// context_param
		@SuppressWarnings("unchecked")
		Iterator<Element> contextParams = webapp.elements("context-param")
				.iterator();
		if (contextParams != null) {
			while (contextParams.hasNext()) {
				ContextParamDef cpd = new ContextParamDef();
				System.out.println("!!!!");
				Element contextParam = contextParams.next();
				Element paramName = contextParam.element("param-name");
				System.out.println(paramName.getName() + ":"
						+ paramName.getTextTrim());
				cpd.setParam_name(paramName.getTextTrim());
				Element paramValue = contextParam.element("param-value");
				System.out.println(paramValue.getName() + ":"
						+ paramValue.getTextTrim());
				cpd.setParam_value(paramValue.getTextTrim());
				Element paramDescription = contextParam.element("description");
				if (paramDescription != null) {
					System.out.println(paramDescription.getName() + ":"
							+ paramDescription.getTextTrim());
					cpd.setDescription(paramDescription.getTextTrim());
				}
				//
				webappDef.addContext_param(cpd);
			}
		}

		// env-entry
		@SuppressWarnings("unchecked")
		Iterator<Element> envEntrys = webapp.elements("env-entry").iterator();
		if (envEntrys != null) {
			while (envEntrys.hasNext()) {
				System.out.println("!!!!");
				EnvEntryDef eed = new EnvEntryDef();
				Element envEntry = envEntrys.next();
				Element envName = envEntry.element("env-entry-name");
				System.out.println(envName.getName() + ":"
						+ envName.getTextTrim());
				eed.setEnv_entry_name(envName.getTextTrim());
				Element envValue = envEntry.element("env-entry-value");
				System.out.println(envValue.getName() + ":"
						+ envValue.getTextTrim());
				eed.setEnv_entry_value(envValue.getTextTrim());
				Element envType = envEntry.element("env-entry-type");
				System.out.println(envType.getName() + ":"
						+ envType.getTextTrim());
				eed.setEnv_entry_type(envType.getTextTrim());
				Element envDescription = envType.element("description");
				if (envDescription != null) {
					System.out.println(envDescription.getName() + ":"
							+ envDescription.getTextTrim());
					eed.setDescription(envDescription.getTextTrim());
				}
				webappDef.addEnv_entry(eed);
			}
		}
		// servlet
		@SuppressWarnings("unchecked")
		Iterator<Element> servlets = webapp.elements("servlet").iterator();
		while (servlets.hasNext()) {
			System.out.println("####");
			ServletDef sd = new ServletDef();
			Element servlet = servlets.next();
			Element servletName = servlet.element("servlet-name");
			System.out.println(servletName.getName() + ":"
					+ servletName.getTextTrim());
			sd.setServlet_name(servletName.getTextTrim());
			Element servletClass = servlet.element("servlet-class");
			System.out.println(servletClass.getName() + ":"
					+ servletClass.getTextTrim());
			sd.setServlet_class(servletClass.getTextTrim());
			Element loadonStartup = servlet.element("load-on-startup");
			System.out.println(loadonStartup.getName() + ":"
					+ loadonStartup.getTextTrim());
			int startup = IntegerUtil.intFromString(
					loadonStartup.getTextTrim(), 0);
			sd.setLoad_on_startup(startup);

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
				sd.addInitParam(paramName.getTextTrim(),
						paramValue.getTextTrim());
			}
			webappDef.addServlet(sd);
		}

		// servlet-mapping
		@SuppressWarnings("unchecked")
		Iterator<Element> servletMappings = webapp.elements("servlet-mapping")
				.iterator();
		while (servletMappings.hasNext()) {
			System.out.println("%%%%");
			ServletMappingDef smd = new ServletMappingDef();
			Element servletMapping = servletMappings.next();
			Element servletName = servletMapping.element("servlet-name");
			System.out.println(servletName.getName() + ":"
					+ servletName.getTextTrim());
			smd.setServlet_name(servletName.getTextTrim());
			Element urlPattern = servletMapping.element("url-pattern");
			System.out.println(urlPattern.getName() + ":"
					+ urlPattern.getTextTrim());
			smd.setUrl_pattern(urlPattern.getTextTrim());
			webappDef.addServlet_mapping(smd);
		}
		// filter
		@SuppressWarnings("unchecked")
		Iterator<Element> filters = webapp.elements("filter").iterator();
		while (filters.hasNext()) {
			System.out.println("&&&&");
			FilterDef fd = new FilterDef();
			Element filter = filters.next();
			Element filterName = filter.element("filter-name");
			System.out.println(filterName.getName() + ":"
					+ filterName.getTextTrim());
			fd.setFilter_name(filterName.getTextTrim());
			Element filterClass = filter.element("filter-class");
			System.out.println(filterClass.getName() + ":"
					+ filterClass.getTextTrim());
			fd.setFilter_class(filterClass.getTextTrim());

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
				fd.addInitParam(paramName.getTextTrim(),
						paramValue.getTextTrim());
			}
			webappDef.addFilter(fd);
		}

		// filter-mapping
		@SuppressWarnings("unchecked")
		Iterator<Element> filterMappings = webapp.elements("filter-mapping")
				.iterator();
		while (filterMappings.hasNext()) {
			System.out.println("~~~~");
			FilterMappingDef fmd = new FilterMappingDef();
			Element filterMapping = filterMappings.next();
			Element filterName = filterMapping.element("filter-name");
			System.out.println(filterName.getName() + ":"
					+ filterName.getTextTrim());
			fmd.setFilter_name(filterName.getTextTrim());
			Element urlPattern = filterMapping.element("url-pattern");
			System.out.println(urlPattern.getName() + ":"
					+ urlPattern.getTextTrim());
			fmd.setUrl_pattern(urlPattern.getTextTrim());
			webappDef.addFilter_mapping(fmd);
		}

		// listener
		System.out.println("^^^^^");
		@SuppressWarnings("unchecked")
		Iterator<Element> listeners = webapp.elements("listener").iterator();
		while (listeners.hasNext()) {
			Element listener = listeners.next();
			Element listenerClass = listener.element("listener-class");
			System.out
					.println("listenerClass = " + listenerClass.getTextTrim());
			webappDef.addListner_class(listenerClass.getTextTrim());
		}

		// error-page
		System.out.println("******");
		@SuppressWarnings("unchecked")
		Iterator<Element> errorPages = webapp.elements("error-page").iterator();
		while (errorPages.hasNext()) {
			System.out.println("******");
			ErrorPageDef epd = new ErrorPageDef();
			Element errorPage = errorPages.next();

			Element exceptionType = errorPage.element("exception-type");
			if (exceptionType != null) {
				System.out.println(exceptionType.getName() + ":"
						+ exceptionType.getTextTrim());
				epd.setException_type(exceptionType.getTextTrim());
			}
			Element errorCode = errorPage.element("error-code");
			if (errorCode != null) {
				System.out.println(errorCode.getName() + ":"
						+ errorCode.getTextTrim());
				epd.setError_code(errorCode.getTextTrim());
			}
			Element location = errorPage.element("location");
			System.out.println(location.getName() + ":"
					+ location.getTextTrim());
			epd.setLocation(location.getTextTrim());
			webappDef.addError_page(epd);
		}

		// finally
		return webappDef;
	}

}
