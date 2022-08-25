package com.crm.GenricUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	
	public String getValueFromPropertyFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties p=new Properties();
	p.load(fis);
	
	String value=p.getProperty(key);
	return value;
	
	}
	/**
	 * Pass a key to get value from property file
	 */

}
