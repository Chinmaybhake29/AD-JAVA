package example.spring.mvc.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class SpringWebApplicationInitializer implements WebApplicationInitializer{

	private WebApplicationContext getApplicationContext() {
		AnnotationConfigWebApplicationContext webctx=new AnnotationConfigWebApplicationContext();
		webctx.setConfigLocation("example");
		return webctx;
		
	}
	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Application Starting");
		WebApplicationContext webAppCtx=getApplicationContext();
		DispatcherServlet frontcontroller=new DispatcherServlet(webAppCtx);
		
		ServletRegistration.Dynamic registration=ctx.addServlet("myFrontController",frontcontroller);
	//Configuring FrontController servlet that accepts all requests
		registration.addMapping("/");
	}
		
}
