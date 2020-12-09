package com.jdbc.SqlPrint;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentsPrint {
	
	public static void departmentsPrint(ResultSet resultSet) throws SQLException {
		
		StringBuilder builder =new StringBuilder();
		builder.append("Record-->"+ resultSet.getRow());
		builder.append(" ");
		builder.append(resultSet.getString("dept_no"));
		builder.append(" ");
		builder.append(resultSet.getString("dept_name"));
		builder.append(" ");
		
		System.out.println(builder.toString());
		
	}

}
