package com.jdbc.SqlManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.SqlPrint.SalaryPrint;

public class SalariesManager {

	private final static String dbHost = "jdbc:mysql://127.0.0.1:3306/company_db?useSSL=false";
	private final static String userName = "root";
	private final static String password = "Fatma.300";
	private final static String jdbcDriver = "com.mysql.jdbc.Driver";

	public static void selectSalaries() {

		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(jdbcDriver);
			dbConnection = DriverManager.getConnection(dbHost, userName, password);
			statement = dbConnection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM salaries");
			System.out.println("Salaries Tablosu Verileri");

			while (resultSet.next()) {

				SalaryPrint.printSalaries(resultSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException sqlException) {
					
					sqlException.printStackTrace();
				}
			}
		}

	}

}
