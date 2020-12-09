package com.jdbc.InsertSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.jdbc.basic.jdbc.Employee;
import com.mysql.jdbc.PreparedStatement;

public class EmployeeInsert {
	
	private final static String dbHost = "jdbc:mysql://127.0.0.1:3306/company_db?useSSL=false";
	private final static String userName = "root";
	private final static String password = "Fatma.300";
	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	
	public static void insertBulkEmployees() {

		Connection dbConnection = null;

		Employee employee1 = new Employee();
		employee1.setEmp_no(0L);
		employee1.setFirstName("Hüseyin");
		employee1.setLastName("Ayçiçek");
		employee1.setGender("M");
		employee1.setHireDate(new Date());
		employee1.setBirthDate(new Date());

		Employee employee2 = new Employee();
		employee2.setEmp_no(0L);
		employee2.setFirstName("Mert");
		employee2.setLastName("Duru");
		employee2.setGender("M");
		employee2.setHireDate(new Date());
		employee2.setBirthDate(new Date());

		Employee employee3 = new Employee();
		employee3.setEmp_no(0L);
		employee3.setFirstName("Yusuf");
		employee3.setLastName("Ayçiçek");
		employee3.setGender("M");
		employee3.setHireDate(new Date());
		employee3.setBirthDate(new Date());

		Employee employee4 = new Employee();
		employee4.setEmp_no(0L);
		employee4.setFirstName("Ayşe");
		employee4.setLastName("Kaya");
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

			PreparedStatement preparedStatement = (PreparedStatement) dbConnection.prepareStatement(
					"INSERT INTO employees_auto_inc (emp_no, first_name, last_name, gender, birth_date, hire_date) VALUES(?,?,?,?,?,?)");

			Iterator<Employee> iterator = employees.iterator();

			while (iterator.hasNext()) {

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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


}
