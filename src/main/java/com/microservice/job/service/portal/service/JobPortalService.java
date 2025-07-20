package com.microservice.job.service.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.job.service.portal.api.clients.RapidApiClient;
import com.microservice.job.service.portal.entities.RapidAPIRecord;
import com.microservice.job.service.portal.repository.RapidAPIRecordRepository;

@Service
public class JobPortalService {

	@Autowired
	private RapidApiClient rapidApiClient;

	@Autowired
	private RapidAPIRecordRepository rapidAPIRecordRepository;
	
	public RapidAPIRecord callingRapidAPI() {
		RapidAPIRecord callJobPortalExternalAPI = rapidApiClient.callJobPortalExternalAPI();
		return rapidAPIRecordRepository.save(callJobPortalExternalAPI);
	}
}
