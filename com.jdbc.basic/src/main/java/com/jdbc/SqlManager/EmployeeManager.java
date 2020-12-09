package com.jdbc.SqlManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.SqlPrint.EmployeePrint;

public class EmployeeManager {

	private final static String dbHost = "jdbc:mysql://127.0.0.1:3306/company_db?useSSL=false";
	private final static String userName = "root";
	private final static String password = "Fatma.300";
	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	
	public static void selectEmployees() {

		Connection dbConnection = null;

		try {
			// Class sınıfındaki “forName” fonksiyonu ile hangi veri tabanı sürücüsünü
			// kullanacağımızı
			// belirtiyoruz.
			
			Class.forName(jdbcDriver);
			dbConnection = DriverManager.getConnection(dbHost, userName, password);
			Statement statement = dbConnection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employees_auto_inc");
			System.out.println("Employees Tablosu");

			while (resultSet.next()) {

				EmployeePrint.printEmployee(resultSet);
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// final bloğu koyduk çünkü her ne olursa olsun bağlantıyı kapatmayı garanti
		// etmiş olduk.
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
