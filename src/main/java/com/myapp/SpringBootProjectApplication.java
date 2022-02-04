package com.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author SUBHASHIS
 *
 */
@SpringBootApplication
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

	/*
	 * @Bean public ServletListenerRegistrationBean<ServletContextListener>
	 * customListenerBean() {
	 * ServletListenerRegistrationBean<ServletContextListener> bean = new
	 * ServletListenerRegistrationBean(); bean.setListener(new CustomListener());
	 * return bean; }
	 */

}
