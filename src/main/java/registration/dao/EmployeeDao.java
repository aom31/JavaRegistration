package registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import registration.model.Employee;

public class EmployeeDao {
	
	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO employee" + 
						"(id, first_name, last_name, username, password, address, contract) VALUES"+
						"(?,?,?,?,?,?,?);";
		int result=0;
		
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaprojects?useSSL=false", "root", "3143");
				//create statement using connection object
				PreparedStatement prepareStatement = connection.prepareStatement(INSERT_USERS_SQL)){
			prepareStatement.setInt(1,1);
			prepareStatement.setString(2, employee.getFirstname());
			prepareStatement.setString(3, employee.getLastname());
			prepareStatement.setString(4, employee.getUsername());
			prepareStatement.setString(5, employee.getPassword());
			prepareStatement.setString(6, employee.getAddress());
			prepareStatement.setString(7, employee.getContract());
		
			System.out.println(prepareStatement);
			//excute query or update query
			result = prepareStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return result;
	}

	

}
