package com.microservice.job.service.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.job.service.portal.api.clients.RapidApiClient;
import com.microservice.job.service.portal.entities.RapidAPIRecord;
import com.microservice.job.service.portal.pojos.JobResponse;
import com.microservice.job.service.portal.repository.RapidAPIRecordRepository;

@Service
public class JobPortalService {

	@Autowired
	private RapidApiClient rapidApiClient;
	
	@Autowired
	private Mapper mapper;

	@Autowired
	private RapidAPIRecordRepository rapidAPIRecordRepository;
	
	public JobResponse callingRapidAPI() {
		// Calling External Rapid API 
		RapidAPIRecord callJobPortalExternalAPI = rapidApiClient.callJobPortalExternalAPI();
		
		// Saving the External API Response in DB [RapidAPIRecord] for Tracking Purpose
		rapidAPIRecordRepository.save(callJobPortalExternalAPI);
		
		// Mapping Json Object to JobResponse Bean
		return mapper.convertJsonToJobResponse(callJobPortalExternalAPI.getResponse());
	}
}
