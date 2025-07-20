package com.microservice.job.service.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.job.service.portal.entities.RapidAPIRecord;
import com.microservice.job.service.portal.service.JobPortalService;

@RestController
@RequestMapping("/api")
public class JobPortalController {

	@Autowired
	private JobPortalService jobPortalService;
	
	@GetMapping("/job-search")
	public RapidAPIRecord callingJobPortalService() {
		return jobPortalService.callingRapidAPI();
		
	}
}
