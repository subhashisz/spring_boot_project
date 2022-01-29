package com.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.model.HelloWorldBean;
/**
 * 
 * @author SUBHASHIS
 *
 */
@RestController
public class HelloController {
	Logger logger = LoggerFactory.getLogger(HelloController.class);

	@GetMapping("/hello-world")
	public String hello() {
		logger.trace("A TRACE Message from {}", logger.getName());
		logger.debug("A DEBUG Message from {}", logger.getName());
		logger.info("An INFO Message from {}", logger.getName());
		logger.warn("A WARN Message from {}", logger.getName());
		logger.error("An ERROR Message from {}", logger.getName());
		return "Hello World";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		logger.info("An INFO Message from {}", logger.getName());
		return new HelloWorldBean("Hello World Bean");
	}

	@GetMapping("/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		logger.info("An INFO Message from {}", logger.getName());
		return new HelloWorldBean("Hello World Bean " + name);
	}

}
