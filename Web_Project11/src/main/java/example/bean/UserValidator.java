package example.bean;

public class UserValidator {
	public static boolean isValid(User u) {
		boolean result=false;
		
		String userid=u.getUserName();
		String password=u.getPassword();
		
		if(userid.equals("admin")&&password.equals("admin123")) {
			
		}
		result=true;
		return result;
	}
}
