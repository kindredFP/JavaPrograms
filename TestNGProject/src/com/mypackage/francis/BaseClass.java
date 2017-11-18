package com.mypackage.francis;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.http.HttpEntity;

public class BaseClass {

	public static String convertInputStreamToString(InputStream is) {
		try {
			return new java.util.Scanner(is).useDelimiter("\\A").next();
		} catch (java.util.NoSuchElementException e) {
			return "";
		}
	}

	public static String getHttpContent(HttpEntity entity) {
		try {
			if (entity == null) {
				return null;
			}

			return convertInputStreamToString(entity.getContent());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Connection getOracleConnection() {

		Connection connection = null;
		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;

		}

		//System.out.println("Oracle JDBC Driver Registered!");

		try {

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.236.58.231:1521:FUNCNADB", "icrs22",
					"change1t");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}

		if (connection != null) {
			System.out.println("Successful connection!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
	}

	public static String queryDB(String query,Connection con) {
		Statement stmt = null;
		String deviceId = "";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			//while (rs.next()) {
			rs.next();
				deviceId = rs.getString("PIN_IDENTIFIER");
			//}
		} catch (SQLException e) {
			System.out.println ("SQL Exception" + e);
		} finally {
			if (stmt != null) {
				try{
				stmt.close();
				}
				catch (Exception e){
					System.out.println ("Statement did not close " + e);
				}
			}
		}
		return deviceId;
	}
}
