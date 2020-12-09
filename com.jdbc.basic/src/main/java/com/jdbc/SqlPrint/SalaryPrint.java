package com.jdbc.SqlPrint;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryPrint {
	
	public static void printSalaries(ResultSet resultSet) throws SQLException{
		
		StringBuilder builder=new StringBuilder();
		builder.append("Record-->"+ resultSet.getRow());
		builder.append("---->");
		builder.append(resultSet.getInt("emp_no"));
		builder.append(" ");
		builder.append(resultSet.getInt("salary"));
		builder.append(" ");
		builder.append(resultSet.getDate("from_date"));
		builder.append(" ");
		builder.append(resultSet.getDate("to_date"));
		builder.append(" ");
		
		System.out.println(builder.toString());
		
	}

}
