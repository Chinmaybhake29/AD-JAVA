package example.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.xdevapi.PreparableStatement;

import example.jbc.Database.jdbcUtils;
import example.jdbc.bean.Restaurant.Restaurant;

public class RestaurantDao implements DaoInterface<Restaurant, Integer> {

	public Collection<Restaurant> retrieveAll() {
		/*
		 * This method connects to DB, Fetches all record, convert them into java
		 * Objects of Restaurant class, puts those objects into some collection and
		 * returns the collection
		 */
		// Creating an Empty ArrayList
		Collection<Restaurant> allRestaurants = new ArrayList<Restaurant>();
		String sqlQuery = "select * from restaurant_master";
		try (
				// Opening The Resources using try-catch resources so that they get
				// closed automatically
				Connection conn = jdbcUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery)) {
			while (rs.next()) {
				int restaurantId = rs.getInt(1);
				String restaurantName = rs.getString(2);
				String restaurantCuisine = rs.getString(3);
				int branchCount = rs.getInt(4);
				Restaurant rst = new Restaurant(restaurantId, restaurantName, restaurantCuisine, branchCount);
				allRestaurants.add(rst);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allRestaurants;
	}

	public Restaurant retrieveOne(Integer id) {
		Restaurant foundRestaurant = null;
		String sqlQuery = "select * from restaurant_master where rest_id=?";
		try (Connection conn = jdbcUtils.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlQuery);

		) {
			pstmt.setInt(1, id);
			ResultSet ts = pstmt.executeQuery();
			if (ts.next()) {
				int restaurantId = ts.getInt(1);
				String restaurantName = ts.getString(2);
				String restaurantCuisine = ts.getString(3);
				int branchCount = ts.getInt(4);
				foundRestaurant = new Restaurant(restaurantId, restaurantName, restaurantCuisine, branchCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foundRestaurant;
	}

	public void create(Restaurant newRestaurant) {
		/*
		 * This method accepts a 'Restaurant' object: newRestaurant and stores it as a
		 * record in the DB table
		 */
		String sqlQuery = "insert into restaurant_master values(?,?,?,?)";

		try (

				Connection con = jdbcUtils.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlQuery);) {

			int rest_id = newRestaurant.getRestaurantId();
			String rest_name = newRestaurant.getName();
			String rest_cuisine = newRestaurant.getCuisine();
			int rest_branch_count = newRestaurant.getBranchCount();

			ps.setInt(1, rest_id);
			ps.setString(2, rest_name);
			ps.setString(3, rest_cuisine);
			ps.setInt(4, rest_branch_count);
			int updatecount = ps.executeUpdate();

			System.out.println(updatecount + "Record Inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(Restaurant Modify) {
		String sqlquery="update restaurant_master set rest_name=?, rest_cuisine=?, rest_branch_count=? where  rest_id=?";
		
		
		try (Connection con=jdbcUtils.getConnection();
			 PreparedStatement ps=con.prepareStatement(sqlquery);){
			
		//Capturing the modified the state of object 
			
			int rest_id = Modify.getRestaurantId();
			String rest_name = Modify.getName();
			String rest_cuisine = Modify.getCuisine();
			int rest_branch_count = Modify.getBranchCount();
			
//			ps.setInt(rest_id, rest_branch_count);
//			ps.setString(rest_branch_count, rest_cuisine);
			
			ps.setInt(4, rest_id);
			ps.setString(1, rest_name);
			ps.setString(2, rest_cuisine);
			ps.setInt(3, rest_branch_count);

			int update=ps.executeUpdate();
			System.out.println(update+"Record Update Sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(Integer id) {
		/*
		 * This method performs record deletion against identity 
		 */
		
		String sqlQuery="delete from restaurant_master where rest_id=?";
		try (
			Connection con=jdbcUtils.getConnection();
			PreparedStatement st=con.prepareStatement(sqlQuery);
			){
			st.setInt(1, id);
			int delete=st.executeUpdate();
			System.out.println(delete+"REcord Deleted");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
