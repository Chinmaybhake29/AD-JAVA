package example.jbc.Database;


import java.util.Collection;

import example.jbc.Database.jdbcUtils;
import example.jdbc.bean.Restaurant.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class RetriveAllUsingDaoExam {
		public static void main(String args[]) {
			DaoInterface<Restaurant, Integer> daoRef=new RestaurantDao();
			Collection<Restaurant>  allRestaurants=daoRef.retrieveAll();
			
			for(Restaurant currentRestaurant:allRestaurants)
				System.out.println(currentRestaurant);
			System.out.println("===============================");
		}
		
	
}
