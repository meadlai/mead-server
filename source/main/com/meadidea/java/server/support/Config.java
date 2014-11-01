package com.meadidea.java.server.support;


import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * IConfig,配置条目，缓存类<br>
 * 获取数据库配置等<br>
 * 读取database.config文件。
 * 
 * @author mead
 * @since 2012-04-17
 * @version 1.0
 * 
 */
public class Config {
	private static HashMap<String, String> map = new HashMap<String, String>(8);
	private static Logger logger = Logger.getLogger(Config.class);

	private Config() {
		InputStream ios = this.getClass().getClassLoader()
				.getResourceAsStream("config.property");
		System.out.println("== " + ios);
		Properties p = new Properties();
		try {
			p.load(ios);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Enumeration<?> en = p.propertyNames();// �õ���Դ�ļ��е�����keyֵ
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String val = (String) p.get(key);
			//System.out.println("key=" + key + " val=" + val);
			map.put(key, val);
		}
		// prop.put("", "");
	}

	private static class Holder {
		private final static Config instance = new Config();
	}

	public static Config instance() {
		return Holder.instance;
	}

	/**
	 * 获取config里面的配置信息
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		String val = map.get(key);
		if(val == null){
			logger.error("CONFIG:EX100:配置项目："+key+"为空！");
			//throw new RuntimeException("CONFIG:EX100:配置项目："+key+"为空！");
		}
		return val;
	}
	
	/**
	 * 设置config里面的配置信息<br>
	 * 可以添加新的key，或者覆盖key
	 * @param key
	 * @param val
	 * @return
	 */
	public String setValue(String key, String val){
		if(key==null){
			logger.error("CONFIG:EX102:配置项目："+key+"为空！");
			//throw new RuntimeException("CONFIG:EX102:配置项目："+key+"为空！");
		}
		logger.info("CONFIG:INFO101:添加配置项目："+key+",val="+val);
		String old = map.get(key);
		map.put(key, val);
		if(old != null){
			return old;
		}
		return "";
	}
	
	public static void main(String [] args){
		String val = Config.instance().getValue("jdbc_url");
		System.out.println(val);
		String ignored = Config.instance().getValue("o32_synchronize_dic_ignored");
		if(ignored !=null && !ignored.trim().equals("")){
			String[] iglist = ignored.split(",");
			List<String> list = Arrays.asList(iglist);
			if(list.contains("1")){
				System.out.println(ignored);
				System.out.print("contains=1");
			}
		}
	}

}

