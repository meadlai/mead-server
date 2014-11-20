package com.meadidea.java.server.loader.imp;

import java.net.URL;
import java.security.cert.Certificate;
import java.util.jar.Manifest;

public class ResourceEntry {
	public long lastModified = -1;

	public byte[] binaryContent = null;

	public Class<?> loadedClass = null;

	public URL source = null;

	public URL codeBase = null;

	public Manifest manifest = null;

	public Certificate[] certificates = null;

}
