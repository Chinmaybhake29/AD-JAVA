package example.jbc.Database;

import example.jdbc.bean.Restaurant.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class CreateUsingDaoExample {
		public static void main(String args[]) {
			DaoInterface<Restaurant, Integer>daoRef=new RestaurantDao();
			Restaurant rst=new Restaurant(106, "BarbeeQuee","Indian", 67);
			daoRef.create(rst);
			
		}
}
