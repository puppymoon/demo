package com.moon.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogTest {

//	@Autowired
//	private Logger logger;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final org.apache.log4j.Logger logger2 = org.apache.log4j.Logger.getLogger(getClass());

	@Test
	void testLog() {

		logger.info("org.slf4j.Logger: " + "info");
		logger.debug("org.slf4j.Logger: " + "debug");

		logger.info("org.apache.log4j.Logger: " + "info");
		logger.debug("org.apache.log4j.Logger: " + "debug");
		
	}

}
