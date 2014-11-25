package com.meadidea.java.server.connector;

import com.meadidea.java.server.container.Container;
import com.meadidea.java.server.lifecycle.Lifecycle;

public interface Connector extends Lifecycle {

	public Container getContainer();

	public void setContainer(Container container);
}
