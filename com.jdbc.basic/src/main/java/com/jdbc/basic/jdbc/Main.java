package com.jdbc.basic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class Main {
	
	
	private final static String dbHost="jdbc:mysql://127.0.0.1:3306/company_db?useSSL=false";
	private final static String userName="root";
	private final static String password="Fatma.300";
	private final static String jdbcDriver="com.mysql.jdbc.Driver";
	


	public static void main(String[] args) {
		
		selectEmployees();
		insertBulkEmployees();

	}
	
	private static void selectEmployees() {
		
		Connection dbConnection =null;
		
		try {
			//Class sınıfındaki “forName” fonksiyonu ile hangi veri tabanı sürücüsünü kullanacağımızı
			//belirtiyoruz.
			Class.forName(jdbcDriver);
			dbConnection=DriverManager.getConnection(dbHost, userName, password);
			Statement statement=dbConnection.createStatement();
			ResultSet resultSet=statement.executeQuery("SELECT * FROM employees_auto_inc");
			System.out.println("Employees Tablosu");
			
			while(resultSet.next()) {
				
				printEmployee(resultSet);
			}
			System.out.println();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//final bloğu koyduk çünkü her ne olursa olsun bağlantıyı kapatmayı garanti etmiş olduk.
		finally {
			if(dbConnection !=null) {
				try {
					dbConnection.close();
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		}
	}
	
private static void insertBulkEmployees() {
		
		Connection dbConnection = null;
		
		Employee employee1 = new Employee();
		employee1.setEmp_no(0L);
		employee1.setFirstName("Arda");
		employee1.setLastName("Ayçiçek");
		employee1.setGender("M");
		employee1.setHireDate(new Date());
		employee1.setBirthDate(new Date());
		
		Employee employee2 = new Employee();
		employee2.setEmp_no(0L);
		employee2.setFirstName("Okan");
		employee2.setLastName("Çavdar");
		employee2.setGender("M");
		employee2.setHireDate(new Date());
		employee2.setBirthDate(new Date());
		
		Employee employee3 = new Employee();
		employee3.setEmp_no(0L);
		employee3.setFirstName("Mert");
		employee3.setLastName("Demir");
		employee3.setGender("M");
		employee3.setHireDate(new Date());
		employee3.setBirthDate(new Date());
		
		
		Employee employee4= new Employee();
		employee4.setEmp_no(0L);
		employee4.setFirstName("Elif");
		employee4.setLastName("Paksoy");
		employee4.setGender("F");
		employee4.setHireDate(new Date());
		employee4.setBirthDate(new Date());
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		
		try {
			
			Class.forName(jdbcDriver);
			dbConnection = DriverManager.getConnection(dbHost, userName, password);
			
			PreparedStatement preparedStatement = 
					(PreparedStatement) dbConnection.prepareStatement("INSERT INTO employees_auto_inc (emp_no, first_name, last_name, gender, birth_date, hire_date) VALUES(?,?,?,?,?,?)");

			
			Iterator<Employee> iterator = employees.iterator();
			
			while(iterator.hasNext()) {
				
				Employee employee = iterator.next();
				
				preparedStatement.setLong(1, employee.getEmp_no());
				preparedStatement.setString(2, employee.getFirstName());
				preparedStatement.setString(3, employee.getLastName());
				preparedStatement.setString(4, employee.getGender());
				preparedStatement.setDate(5, new java.sql.Date(employee.getBirthDate().getTime()));
				preparedStatement.setDate(6, new java.sql.Date(employee.getHireDate().getTime()));
				
				preparedStatement.addBatch();          
			}
			
			int[] effectedRows = preparedStatement.executeBatch();
			
			System.out.println(effectedRows.length + " rows inserted in employees_auto_inc table!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void printEmployee(ResultSet resultSet) throws SQLException {
		
		StringBuilder builder =new StringBuilder();
		builder.append("Record-"+ resultSet.getRow());
		builder.append("***********");
		builder.append(resultSet.getLong("emp_no"));
		builder.append(" ");
		builder.append(resultSet.getLong("first_name"));
		builder.append(" ");
		builder.append(resultSet.getLong("last_name"));
		builder.append(" ");
		builder.append(resultSet.getLong("gender"));
		builder.append(" ");
		builder.append(resultSet.getLong("birth_date"));
		builder.append(" ");
		builder.append(resultSet.getLong("hire_date"));
		builder.append(" ");
		
		System.out.println(builder.toString());
		
		
	}
	
	

}
