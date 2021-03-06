package com.brasajava;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringJsfApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringJsfApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SpringJsfApplication.class,Initializer.class);
	}
	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
		return servletRegistrationBean;
	}
	
	/*@Bean
    public FacesServlet facesServlet() {
        return new FacesServlet();
    }
	@Bean
	public ViewScope viewScope(){
		return new ViewScope();
	}
	@Bean
	public CustomScopeConfigurer customScopeConfigurer(){
		CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
		customScopeConfigurer.addScope("view", viewScope());
		return customScopeConfigurer;
	}*/

}
