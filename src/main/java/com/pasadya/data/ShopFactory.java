package com.pasadya.data;

import java.util.Properties;

import com.pasadya.data.util.DatabasePropertiesConstants;
import com.pasadya.data.util.PropertiesLoader;

public class ShopFactory {

	private static IShopDAO instance;

	public static IShopDAO getInstance() {
		if (instance == null) {
			Properties configProps = PropertiesLoader
					.loadProperties(PropertiesLoader.CONFIGURATION_PROPERTIES_FILE);
			String dbConfigFile = configProps
					.getProperty(PropertiesLoader.CONFIG_KEY_DAO_PROPS_FILE);

			Properties dbProps = PropertiesLoader.loadProperties(dbConfigFile);

			String className = (String) dbProps
					.getProperty(DatabasePropertiesConstants.DAO_IMPL);
			IShopDAO dao = null;
			Class<?> clazz = null;
			try {
				clazz = Class.forName(className);
				dao = (IShopDAO) clazz.newInstance();
				instance = dao;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}
