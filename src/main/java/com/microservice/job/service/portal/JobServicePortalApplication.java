package com.microservice.job.service.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JobServicePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobServicePortalApplication.class, args);
	}

}
