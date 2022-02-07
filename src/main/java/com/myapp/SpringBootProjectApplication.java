package com.myapp;

import javax.servlet.ServletContextListener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.myapp.listner.CustomListener;

/**
 * 
 * @author SUBHASHIS
 *
 */
@SpringBootApplication
public class SpringBootProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// this methods runs when SpringBoot application starts
	}

	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> customListenerBean() {
		ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean();
		bean.setListener(new CustomListener());
		return bean;
	}

}
