package example.jbc.Database;

import example.jdbc.bean.Restaurant.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class UpdateusingDaoExample {
	public static void main(String[] args) {
		DaoInterface<Restaurant, Integer>daoexample=new RestaurantDao();
		Restaurant rs=daoexample.retrieveOne(104);
		rs.setName("New Little Italy");
		rs.setBranchCount(20);
		System.out.println("Update Sucessfully");
		daoexample.update(rs);
		
	}
}
