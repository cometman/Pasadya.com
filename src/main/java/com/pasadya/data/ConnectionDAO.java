package com.pasadya.data;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.pasadya.data.util.DatabasePropertiesConstants;

public class ConnectionDAO extends StoreJDBC {

	private static final long serialVersionUID = -2992870444648646288L;

	@Override
	protected Connection getConnection() throws SQLException {
		final String username = this.dbProperties
				.getProperty(DatabasePropertiesConstants.USERNAME);
		final String password = this.dbProperties
				.getProperty(DatabasePropertiesConstants.PASSWORD);
		final String server = this.dbProperties
				.getProperty(DatabasePropertiesConstants.DATABASE_SERVER);
		final String database = this.dbProperties
				.getProperty(DatabasePropertiesConstants.DATABASE_NAME);
		final String port = this.dbProperties
				.getProperty(DatabasePropertiesConstants.DATABASE_PORT);

		final String connectionString = String.format(
				"jdbc:mysql://%s:%s/%s?user=%s&password=%s", server, port,
				database, username, password);

		try {
			final String driverName = this.dbProperties
					.getProperty(DatabasePropertiesConstants.DATABASE_DRIVER);
			Driver driver = (Driver) Class.forName(driverName).newInstance();
			DriverManager.registerDriver(driver);
			return DriverManager.getConnection(connectionString);
		} catch (InstantiationException e) {
			throw new SQLException(e);
		} catch (IllegalAccessException e) {
			throw new SQLException(e);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
	}
}
