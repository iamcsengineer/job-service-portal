package com.microservice.job.service.portal.api.clients;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.job.service.portal.entities.RapidAPIRecord;
import com.microservice.job.service.portal.pojos.JobResponse;
import com.microservice.job.service.portal.repository.RapidAPIRecordRepository;

@Component
public class RapidApiClient {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private RapidAPIRecordRepository rapidAPIRecordRepository;

	@Value("${job-service-portal.base.url}")
	private String baseUrl;

	@Value("${job-service-portal.headers.keys}")
	private String headerKeys;

	@Value("${job-service-portal.headers.values}")
	private String headerValues;

	@Async
	public CompletableFuture<JobResponse>callJobPortalExternalAPI(boolean remoteJob) {

		// Build dynamic URI
		URI uri = UriComponentsBuilder.fromUriString(baseUrl).queryParam("query", "developer jobs in pune")
				.queryParam("page", 1).queryParam("num_pages", 1).queryParam("country", "india")
				.queryParam("date_posted", "all").queryParam("work_from_home",remoteJob) .build().encode().toUri();

		// Set headers from properties files
		HttpHeaders headers = new HttpHeaders();
		String[] keys = headerKeys.split(",");
		String[] values = headerValues.split(",");
		headers.set(keys[0], values[0]);
		headers.set(keys[1], values[1]);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		// Make the GET request
		JobResponse jobResponse = restTemplate.exchange(uri, HttpMethod.GET, entity, JobResponse.class).getBody();

		// Setting Request and Response in RapidAPIRecord
		RapidAPIRecord rapidAPIRecord = new RapidAPIRecord();
		if (jobResponse != null) {
			try {
				rapidAPIRecord.setRequest(objectMapper.writeValueAsString(entity));
				rapidAPIRecord.setResponse(objectMapper.writeValueAsString(jobResponse));
				rapidAPIRecord.setCreatedAt(LocalDateTime.now());
				rapidAPIRecord.setRemoteJob(remoteJob);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			// Saving the External API Response in DB [RapidAPIRecord] for Tracking Purpose
			rapidAPIRecordRepository.save(rapidAPIRecord);
		}
		return CompletableFuture.completedFuture(jobResponse);
	}
}
