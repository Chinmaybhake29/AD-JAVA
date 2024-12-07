package example.utils;

import java.sql.Connection;
import java.sql.*;

public class jdbcUtils {

	// This is utility class for Optaining a Connection and returning the same
	public static Connection getConnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/zomato";
		String uid = "root";
		String pasword = "password";

		Connection dbConnection=DriverManager.getConnection(url,uid,pasword);
		return dbConnection;

	}

}
