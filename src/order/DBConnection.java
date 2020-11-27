package order;

import java.sql.*;

public class DBConnection {
	public static Connection makeConnection() {

		Connection con = null; 
		String user = "EUNBI"; 
		String password = "1234"; 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("DB ����̹� �ε� ���� "+e.toString()); 
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB ���� ���� "+e.toString());
			e.printStackTrace();
		}			
      
		return con;
	} 

}
