package example.jbc.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SimpleselectQueryEx {

	public static void main(String[] args){
		//Load The Driver --Step - 1
		String driverClassName="com.mysql.cj.jdbc.Driver";
		
		//Established Connection --Step - 2
		String url="jdbc:mysql://localhost:3306/zomato";
		String uid="root";
		String pasword="password";
		
		Connection dbConnection=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driverClassName);
			System.out.println("Driver Loaded");
			
		    dbConnection=DriverManager.getConnection(url,uid,pasword);
			System.out.println("Connected to DB");
			
			//Obtain Some Statement --Step - 3
		    st=dbConnection.createStatement();
			System.out.println("Obtained The Statement");
			
			//Execute the Query
			String sqlQuery="Select rest_name, rest_cuisine, rest_branch_count from restaurant_master";
		    rs=st.executeQuery(sqlQuery);
			System.out.println("Executed SQL SELECT query and obtained Resultset");
		
		    //In case of SELECT query, obtain ResultSet and Perform navigation
			while(rs.next()) {
			String restaurantName=rs.getString(1);
				String restaurantCuisine=rs.getString(2);
				int branchCount=rs.getInt(3);
				System.out.println(restaurantName + " : "+ restaurantCuisine +" : " + branchCount);
			}
		} catch (ClassNotFoundException | SQLException  e) {
			System.out.println("Sorry Unable to Connected");
		}
		finally {
			try {
				rs.close();
				st.close();
				dbConnection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		//PreparedStatement
		//CallableStatement
	  	//RsultSet

	}

}
