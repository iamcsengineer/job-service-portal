package com.microservice.job.service.portal.service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		JobResponse callJobPortalExternalAPI = null;
		Duration duration = Duration.ZERO;

		RapidAPIRecord retrieveLastRecord = rapidAPIRecordRepository.retrieveLastRecord();

		if (retrieveLastRecord != null) {
			duration = Duration.between(retrieveLastRecord.getCreatedAt(), LocalDateTime.now());
		}

		/*
		 * Invoke the external API at intervals of 30 minutes. If the last fetch
		 * occurred less than 30 minutes ago, serve the data from the database instead.
		 */
		if (duration.toMinutes() == 0 || duration.toMinutes() >= 30) {
			// Calling External Rapid API
			callJobPortalExternalAPI = rapidApiClient.callJobPortalExternalAPI();
		} else {
			// Fetching the data from DB.
			callJobPortalExternalAPI = mapper.convertJsonToJobResponse(retrieveLastRecord.getResponse());
		}

		return callJobPortalExternalAPI;
	}
}
