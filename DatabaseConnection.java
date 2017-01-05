package bank.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public DatabaseConnection(){
		super();
	}
	
	public static Connection getConnection() {
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		Connection connection;
			
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplication","root","shireesh");
			return connection;
		}
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}