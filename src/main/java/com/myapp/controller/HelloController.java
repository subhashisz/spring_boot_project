package com.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
