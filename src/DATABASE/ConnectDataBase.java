package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDataBase {

	private Connection connection;
	
	public ConnectDataBase() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QLDKHP9";
		try {
			connection = DriverManager.getConnection(url , "sa", "toilatoi123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
//	public static void main(String[] args) {
//		ConnectDataBase db = new ConnectDataBase();
//		System.out.println("aa");
//	}

   
}
