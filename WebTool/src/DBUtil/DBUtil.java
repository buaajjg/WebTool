package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public DBUtil() {
		// TODO Auto-generated constructor stub
	}
	
	//String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// String url="jdbc:sqlserver://localhost:1433; DatabaseName=testbase";
	//String username="sa";
	//String password="123456";
	//url=jdbc:mysql://127.0.0.1:3306/shop?characterEncoding=utf8&useSSL=true
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true";
	String username="root";
	String password="123456";
	
	public Connection getConnection(){
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, username, password);
			return conn;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return null;
	}
	
	public void close(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void main(String [] args){
		System.out.println("000");
	}
	

}
