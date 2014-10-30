package com.meadidea.java.server.lifecycle;

public class LifecycleException extends Exception {

	private static final long serialVersionUID = 1577247398303438396L;
	/**
	 * The error message passed to our constructor (if any)
	 */
	protected String message = null;

	/**
	 * The underlying exception or error passed to our constructor (if any)
	 */
	protected Throwable throwable = null;

	public LifecycleException(String message) {
		this(message, null);

	}

	public LifecycleException(String message, Throwable throwable) {
		super();
		this.message = message;
		this.throwable = throwable;

	}
	
	/**
     * Return a formatted string that describes this exception.
     */
    public String toString() {

        StringBuffer sb = new StringBuffer("LifecycleException:  ");
        if (message != null) {
            sb.append(message);
            if (throwable != null) {
                sb.append(":  ");
            }
        }
        if (throwable != null) {
            sb.append(throwable.toString());
        }
        return (sb.toString());

    }

}
