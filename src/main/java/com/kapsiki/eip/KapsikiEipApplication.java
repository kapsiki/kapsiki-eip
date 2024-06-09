package com.kapsiki.eip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.openmrs.eip.app.config.AppConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@ComponentScan
@Import(AppConfig.class)
public class KapsikiEipApplication {
	private static final Logger logger = LoggerFactory.getLogger(KapsikiEipApplication.class);

	public static void main(String[] args) {
		logger.info("Starting the kapsiki EIP application...");
		SpringApplication.run(KapsikiEipApplication.class, args);
	}

}
