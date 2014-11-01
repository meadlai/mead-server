/**
 * 
 */
package com.meadidea.java.server;

import com.meadidea.java.server.connector.Connector;
import com.meadidea.java.server.connector.ConnectorFactory;
import com.meadidea.java.server.lifecycle.Lifecycle;
import com.meadidea.java.server.lifecycle.LifecycleException;
import com.meadidea.java.server.lifecycle.LifecycleListener;
import com.meadidea.java.server.service.Service;

/**
 * 读取配置文件server.xml，初始化Server服务器 <br>
 * 启动Service服务。
 * 
 * @author meadlai
 *
 */
public class HttpSever implements Lifecycle {
	private Connector connector = null;
	private Service service = null;

	@Override
	public void addLifecycleListener(LifecycleListener listener) {

	}

	@Override
	public LifecycleListener[] findLifecycleListeners() {
		return null;
	}

	@Override
	public void removeLifecycleListener(LifecycleListener listener) {

	}

	@Override
	public void start() throws LifecycleException {
		this.connector = ConnectorFactory.instance().getConnector("common");
		this.connector.start();
	}

	@Override
	public void stop() throws LifecycleException {

	}

}
