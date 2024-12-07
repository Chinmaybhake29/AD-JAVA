package example.spring.mvc.model;


public class UserValidator {
	public static boolean isValid(user u) {
		boolean result=false;
		
		String userid=u.getUserName();
		String password=u.getPassword();
		
		if(userid.equals("admin")&&password.equals("admin123")) 
		result=true;
		return result;
	}
}
