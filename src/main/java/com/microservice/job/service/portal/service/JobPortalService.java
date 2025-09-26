package com.microservice.job.service.portal.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservice.job.service.portal.api.clients.RapidApiClient;
import com.microservice.job.service.portal.caching.CachingBuilder;
import com.microservice.job.service.portal.entities.RapidAPIRecord;
import com.microservice.job.service.portal.mapper.Mapper;
import com.microservice.job.service.portal.pojos.JobResponse;
import com.microservice.job.service.portal.ui.JobPortal;

@Service
public class JobPortalService {

	@Autowired
	private RapidApiClient rapidApiClient;

	@Autowired
	private Mapper mapper;

	@Autowired
	private CachingBuilder cachingBuilder;

	public JobPortal callingRapidAPI() throws InterruptedException, ExecutionException, JsonProcessingException {

		JobResponse callJobPortalExternalAPI = null;

		Long millisDuration = 0L;
		Long minutesDuration = 0L;

		RapidAPIRecord retrieveLastRecord = cachingBuilder.retrieveLastRecordFromDB();

		if (retrieveLastRecord != null) {
			millisDuration = Duration.between(retrieveLastRecord.getCreatedAt(), LocalDateTime.now()).toMillis();
			minutesDuration = Duration.between(retrieveLastRecord.getCreatedAt(), LocalDateTime.now()).toMinutes();
		}

		/*
		 * Invoke the external API at intervals of 30 minutes. If the last fetch
		 * occurred less than 30 minutes ago, serve the data from the database instead.
		 */
		if (millisDuration == 0 || minutesDuration >= 30) {
			// Calling External Rapid API
			
			//@Async call for WFH/Remote Jobs
			CompletableFuture<JobResponse> callJobPortalExternalAPIWithWFH = rapidApiClient
					.callJobPortalExternalAPI(true);
			
			//@Async call for Non-WFH/Non-Remote Jobs
			CompletableFuture<JobResponse> callJobPortalExternalAPIWithoutWFH = rapidApiClient
					.callJobPortalExternalAPI(false);

			//Combining Job's Objects
			callJobPortalExternalAPI = mapper.combineRemoteJobObjectsWithNonRemoteJob(
					callJobPortalExternalAPIWithWFH.get(), callJobPortalExternalAPIWithoutWFH.get());

		} else {
			// Fetching the data from DB.
			callJobPortalExternalAPI = mapper.convertJsonToJobResponse(retrieveLastRecord.getResponse());
		}

		JobPortal convertJobResponseToJobPortal = mapper.convertJobResponseToJobPortal(callJobPortalExternalAPI);

		return convertJobResponseToJobPortal;
	}
}
