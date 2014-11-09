package com.meadidea.java.server.deploy.description;

public final class LoginConfigDef {

	private String loginPage = null;
	private String errorPage = null;
	/**
	 * BASIC, DIGEST, FORM, or CLIENT-CERT.
	 */
	private String authMethod = null;
	private String realmName = null;

	public LoginConfigDef() {
		super();

	}

	public LoginConfigDef(String authMethod, String realmName,
			String loginPage, String errorPage) {
		super();
		setAuthMethod(authMethod);
		setRealmName(realmName);
		setLoginPage(loginPage);
		setErrorPage(errorPage);

	}

	// ------------------------------------------------------------- Properties

	public String getAuthMethod() {
		return (this.authMethod);
	}

	public void setAuthMethod(String authMethod) {
		this.authMethod = authMethod;
	}

	public String getErrorPage() {
		return (this.errorPage);
	}

	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}

	public String getLoginPage() {
		return (this.loginPage);
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public String getRealmName() {
		return (this.realmName);
	}

	public void setRealmName(String realmName) {
		this.realmName = realmName;
	}

	// --------------------------------------------------------- Public Methods

	/**
	 * Return a String representation of this object.
	 */
	public String toString() {

		StringBuffer sb = new StringBuffer("LoginConfig[");
		sb.append("authMethod=");
		sb.append(authMethod);
		if (realmName != null) {
			sb.append(", realmName=");
			sb.append(realmName);
		}
		if (loginPage != null) {
			sb.append(", loginPage=");
			sb.append(loginPage);
		}
		if (errorPage != null) {
			sb.append(", errorPage=");
			sb.append(errorPage);
		}
		sb.append("]");
		return (sb.toString());

	}
}
