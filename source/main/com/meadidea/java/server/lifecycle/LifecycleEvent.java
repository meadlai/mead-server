package com.meadidea.java.server.lifecycle;

import java.util.EventObject;

/**
 * 
 * @author meadlai
 *
 */
public final class LifecycleEvent extends EventObject  {

	private static final long serialVersionUID = -5394341354216928005L;
	private int type = -1;
	private Object data;


	public LifecycleEvent(Lifecycle lifecycle, int type, Object data) {
        super(lifecycle);
        this.type = type;
        this.data = data;
    }


	public int getType() {
		return type;
	}


	public Object getData() {
		return data;
	}
	
	
}


