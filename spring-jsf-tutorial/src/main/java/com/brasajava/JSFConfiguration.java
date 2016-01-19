package com.brasajava;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.faces.config.FacesInitializer;

@Configuration
public class JSFConfiguration {
	
	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		return new JSFServletRegistrationBean();
		
	}
	public class JSFServletRegistrationBean extends ServletRegistrationBean{
		public JSFServletRegistrationBean(){
			super();
		}
		@Override
		public void onStartup(ServletContext servletContext)throws ServletException{
			FacesInitializer facesInitializer = new FacesInitializer();
			Set<Class<?>> clazz = new HashSet<Class<?>>();
			clazz.add(JSFConfiguration.class);
			facesInitializer.onStartup(clazz, servletContext);
		}
	}

}
