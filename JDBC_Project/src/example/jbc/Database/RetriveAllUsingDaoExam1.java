package example.jbc.Database;

import example.jdbc.bean.Restaurant.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class RetriveAllUsingDaoExam1 {
		public static void main(String args[]) {
			DaoInterface<Restaurant, Integer> daoref=new RestaurantDao();
			
			Restaurant res=daoref.retrieveOne(101);
			if(res!=null) {
				System.out.println(res);
			} else {
				System.out.println("Not exist this id");
			}
		}
}
