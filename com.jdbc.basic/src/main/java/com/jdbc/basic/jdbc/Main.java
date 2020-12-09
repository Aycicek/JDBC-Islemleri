package com.jdbc.basic.jdbc;
import com.jdbc.SqlManager.DepatrmentsManager;
import com.jdbc.SqlManager.EmployeeManager;


public class Main {

	
	public static void main(String[] args) {

		
		
		//SalariesManager.selectSalaries();
		//EmployeeManager.selectEmployees();
		DepatrmentsManager.selectDepartmets();

	}
	
	

	
	
	/*
	 * private static void insertSlaries() {
	 * 
	 * Connection dbConnection=null;
	 * 
	 * Salaries salaries=new Salaries(); salaries.setEmp_no(0);
	 * salaries.setSalary(8000); salaries.setFrom_date(new Date());
	 * salaries.setTo_date(new Date());
	 * 
	 * 
	 * Salaries salaries1=new Salaries(); salaries1.setEmp_no(1);
	 * salaries1.setSalary(10000); salaries1.setFrom_date(new Date() );
	 * salaries1.setTo_date(new Date());
	 * 
	 * List<Salaries> salary =new ArrayList<Salaries>(); salary.add(salaries);
	 * salary.add(salaries1);
	 * 
	 * try { Class.forName(jdbcDriver); dbConnection
	 * =DriverManager.getConnection(dbHost, userName, password);
	 * 
	 * PreparedStatement preparedStatement=(PreparedStatement)
	 * dbConnection.prepareStatement(
	 * "INSERT INTO salaries (emp_no, salary, from_date, to_date) VALUES (?,?,?,?)"
	 * );
	 * 
	 * Iterator<Salaries> itere= salary.iterator();
	 * 
	 * while(itere.hasNext()) {
	 * 
	 * Salaries salary1 =itere.next();
	 * 
	 * preparedStatement.setInt(1, salary1.getEmp_no()); preparedStatement.setInt(2,
	 * salary1.getSalary());
	 * 
	 * preparedStatement.addBatch(); }
	 * 
	 * int[] rows=preparedStatement.executeBatch(); System.out.println(rows.length
	 * +"rows inserted in employees_auto_inc table!");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { if (dbConnection !=
	 * null) { try { dbConnection.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } } } }
	 */
			

	
}
