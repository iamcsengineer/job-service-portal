package com.microservice.job.service.portal.caching;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservice.job.service.portal.entities.RapidAPIRecord;
import com.microservice.job.service.portal.mapper.Mapper;
import com.microservice.job.service.portal.pojos.JobResponse;
import com.microservice.job.service.portal.repository.RapidAPIRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CachingBuilder {

	@Autowired
	private RapidAPIRecordRepository rapidAPIRecordRepository;

	@Autowired
	private Mapper mapper;

	@Cacheable(value = "jobPortalCache", key = "'latestJobs'")
	public RapidAPIRecord retrieveLastRecordFromDB() throws JsonProcessingException {

		String response = "";
		// For Remote Jobs
		RapidAPIRecord retrieveLastRecordForRemoteJobs = rapidAPIRecordRepository.retrieveLastRecord(1);
		// For Non Remote Jobs
		RapidAPIRecord retrieveLastRecordForNonRemoteJobs = rapidAPIRecordRepository.retrieveLastRecord(0);

		if (retrieveLastRecordForRemoteJobs != null && retrieveLastRecordForNonRemoteJobs != null) {
			JobResponse convertJsonToJobResponseRemote = mapper
					.convertJsonToJobResponse(retrieveLastRecordForRemoteJobs.getResponse());
			JobResponse convertJsonToJobResponseNonRemote = mapper
					.convertJsonToJobResponse(retrieveLastRecordForNonRemoteJobs.getResponse());
			JobResponse combineRemoteJobObjectsWithNonRemoteJob = mapper.combineRemoteJobObjectsWithNonRemoteJob(
					convertJsonToJobResponseRemote, convertJsonToJobResponseNonRemote);
			response = mapper.convertJavaToJson(combineRemoteJobObjectsWithNonRemoteJob);
			// Contains Remote + Non-Remote Jobs
			retrieveLastRecordForRemoteJobs.setResponse(response);
			return retrieveLastRecordForRemoteJobs;
		}
		return null;

	}

}
