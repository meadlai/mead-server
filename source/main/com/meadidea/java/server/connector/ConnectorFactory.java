package com.meadidea.java.server.connector;

import com.meadidea.java.server.connector.imp.CommonSocketConnector;

public class ConnectorFactory {
	Connector common;
	
	public Connector getConnector(String type){
		if(type == null){
			
			return this.getCommon();
		}
		return null;
	}
	
	private Connector getCommon(){
		if(common==null){
			synchronized(this){
				common = new CommonSocketConnector();
			}
		}
		return common;
	}
}
