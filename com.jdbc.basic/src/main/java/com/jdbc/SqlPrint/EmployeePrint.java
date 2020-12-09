package com.jdbc.SqlPrint;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeePrint {
	
	public static void printEmployee(ResultSet resultSet) throws SQLException {

		StringBuilder builder = new StringBuilder();
		builder.append("Record-" + resultSet.getRow());
		builder.append("***********");
		builder.append(resultSet.getLong("emp_no"));
		builder.append(" ");
		builder.append(resultSet.getString("first_name"));
		builder.append(" ");
		builder.append(resultSet.getString("last_name"));
		builder.append(" ");
		builder.append(resultSet.getString("gender"));
		builder.append(" ");
		builder.append(resultSet.getDate("birth_date"));
		builder.append(" ");
		builder.append(resultSet.getDate("hire_date"));
		builder.append(" ");

		System.out.println(builder.toString());

	}


}
