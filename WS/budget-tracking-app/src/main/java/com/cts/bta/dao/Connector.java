package com.cts.bta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:sqlanywhere:uid=root;pwd=root;eng=MyDB");
	}
}
