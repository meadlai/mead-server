package com.meadidea.java.server.connector;

import com.meadidea.java.server.connector.imp.CommonSocketConnector;
import com.meadidea.java.server.connector.imp.NioSocketConnector;

public class ConnectorFactory {
	private static Connector common;
	private ConnectorFactory(){
		
	}
	public static ConnectorFactory instance(){
		return holder.cf;
	}
	private static class holder{
		static ConnectorFactory cf = new ConnectorFactory();
	}
	public Connector getConnector(String type) {
		if (type == null) {
			return this.getCommon();
		} else if ("nio".equalsIgnoreCase(type)) {
			return this.getNioSocket();
		}
		return this.getCommon();
	}

	private Connector getCommon() {
		if (common == null) {
			synchronized (this) {
				common = new CommonSocketConnector();
			}
		}
		return common;
	}

	private Connector getNioSocket() {
		return new NioSocketConnector();
	}
}
