package com.pasadya.data.util;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;

public class PropertiesLoader {
	public static final String CONFIGURATION_PROPERTIES_FILE = "/Configuration.properties";
	
	public static final String CONFIG_KEY_DAO_PROPS_FILE = "DAOConfig";
	private static Logger log;
	public static Properties loadProperties(final String propertyFile) 
	{
		InputStream inputStream = PropertiesLoader.class.getResourceAsStream(propertyFile);
		
		if (inputStream == null)
		{
			log.error("Unable to get an inputStream for the property file [" + propertyFile + "]");
			return null;			
		}
		
		Properties props = new Properties();
		try 
		{
			props.load(inputStream);
		}
		catch (Exception e) {
			log.error("Unable to load the properties file [" + propertyFile + "]");
		}
		return props;
		
	}

	
}
