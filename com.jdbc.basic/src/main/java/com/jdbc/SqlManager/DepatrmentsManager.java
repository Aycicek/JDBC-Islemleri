package com.jdbc.SqlManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.jdbc.SqlPrint.DepartmentsPrint;


public class DepatrmentsManager {
	
	private final static String dbHost = "jdbc:mysql://127.0.0.1:3306/company_db?useSSL=false";
	private final static String userName = "root";
	private final static String password = "Fatma.300";
	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	
	public static void selectDepartmets() {
		
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		try {
			Class.forName(jdbcDriver);
			connection=DriverManager.getConnection(dbHost, userName, password);
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT * FROM departments WHERE dept_name='Finance'");
			System.out.println("Departments Tablosu ilgili kayıt");
			
			
			while(resultSet.next()) {
				
				DepartmentsPrint.departmentsPrint(resultSet);
			}
			System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException sqlException) {
					// TODO Auto-generated catch block
					sqlException.printStackTrace();
				}
			}
		}
		
	}
	 

}
