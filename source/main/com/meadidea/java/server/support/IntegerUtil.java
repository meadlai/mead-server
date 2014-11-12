package com.meadidea.java.server.support;

public class IntegerUtil {
	public static Integer intFromString(String input,Integer defaultValue){
		try {
			defaultValue = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return defaultValue;
	}
}
