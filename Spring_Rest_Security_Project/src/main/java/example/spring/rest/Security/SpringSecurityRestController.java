package example.spring.rest.Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityRestController {
	@GetMapping("/doGreet")
	public String getGreeting() {
		return "Welcome to Spring Security";
	}
	//This resource is accessible only to ADMIN work
	@GetMapping("/doAdminWork")
	public String doAdminWork() {
		return "Doing admin work";
	}
	//This Resource is accessible to ADMIN as well as REGULAR users
	@GetMapping("/doRegularWork")
	public String doRegularWork() {
		return "Doing Regular Work";
		
	}
}
