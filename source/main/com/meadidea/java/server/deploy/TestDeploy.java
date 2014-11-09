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

		// 获取根节点对象
		Element webapp = document.getRootElement();
		String webappVersion = webapp.attributeValue("version");
		System.out.println("webappVersion = " + webappVersion);
		Element displayName = webapp.element("display-name");
		System.out.println("displayName = " + displayName.getText());
		Element description = webapp.element("description");
		System.out.println("description = " + description.getText());

		// session_timeout

		// context_param

		// env-entry

		// servlet
		@SuppressWarnings("unchecked")
		Iterator<Element> servlets = webapp.elements("servlet").iterator();
		while (servlets.hasNext()) {
			System.out.println("####");
			Element servlet = servlets.next();
			Element servletName = servlet.element("servlet-name");
			System.out.println(servletName.getName() + ":"
					+ servletName.getText());
			Element servletClass = servlet.element("servlet-class");
			System.out.println(servletClass.getName() + ":"
					+ servletClass.getText());
			Element loadonStartup = servlet.element("load-on-startup");
			System.out.println(loadonStartup.getName() + ":"
					+ loadonStartup.getText());
			// init-param
			@SuppressWarnings("unchecked")
			Iterator<Element> initParms = servlet.elements("init-param")
					.iterator();
			while (initParms.hasNext()) {
				Element initParm = initParms.next();
				Element paramName = initParm.element("param-name");
				System.out.println(paramName.getName() + ":"
						+ paramName.getText());
				Element paramValue = initParm.element("param-value");
				System.out.println(paramValue.getName() + ":"
						+ paramValue.getText());
			}
		}

		// servlet-mapping

		// filter

		// filter-mapping
		
		//listener

	}

}
