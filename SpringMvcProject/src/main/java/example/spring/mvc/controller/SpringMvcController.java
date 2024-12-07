package example.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import example.spring.mvc.model.UserValidator;
import example.spring.mvc.model.user;

@Controller //Marks this class as a controller if Spring MVC Application
public class SpringMvcController {
		@RequestMapping("/doGreet") //providing mapping between the url and page
		public String getIndexPage() {
			System.out.println("Hello World");
			return "index"; //Returning a view name
			
		}
		
		@RequestMapping("/doLogin")
		public String getLoginPage() {
			System.out.println("Inside getLoginPage");
			return"login";
		}
		
		@RequestMapping("/doValidate")
		public String getResultPage(@RequestParam("uid") String userName,
		@RequestParam("pwd") String password) {
			//This method returns one of the 2 possible result pages:
			//Success and failure depending upon user's validity
		
			String resultpage="failure";
			//Building a model object:User Based upon userName and Password
			
			user userdatamodel=new user(userName,password);
			
			boolean valid=UserValidator.isValid(userdatamodel);
			if(valid) {
				resultpage="success";
			}
			return resultpage;
		}
}
