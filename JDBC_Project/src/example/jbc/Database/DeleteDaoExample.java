package example.jbc.Database;

import example.jdbc.bean.Restaurant.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class DeleteDaoExample {
	public static void main(String[] args) {
		DaoInterface<Restaurant, Integer>dao=new RestaurantDao();
		dao.delete(102);
	}
}
