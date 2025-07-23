package com.microservice.job.service.portal.api.clients;

import java.net.URI;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.job.service.portal.entities.RapidAPIRecord;

@Component
public class RapidApiClient {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Value("${job-service-portal.base.url}")
	private String baseUrl;

	@Value("${job-service-portal.headers.keys}")
	private String headerKeys;
	
	@Value("${job-service-portal.headers.values}")
	private String headerValues;
	
	public RapidAPIRecord callJobPortalExternalAPI() {
		
		// Build dynamic URI
		URI uri = UriComponentsBuilder.fromUriString(baseUrl).queryParam("query", "developer jobs in india")
				.queryParam("page", 1).queryParam("num_pages", 1).queryParam("country", "india")
				.queryParam("date_posted", "all").build().encode().toUri();
		
		// Set headers from properties files
		HttpHeaders headers = new HttpHeaders();
		String[] keys = headerKeys.split(",");
		String[] values = headerValues.split(",");
		headers.set(keys[0], values[0]);
		headers.set(keys[1], values[1]);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		// Make the GET request
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		//Saving the External API Response in DB [RapidAPIRecord] for Tracking Purpose
		RapidAPIRecord rapidAPIRecord = new RapidAPIRecord();
		if(response.getBody()!=null) {
			try {
				rapidAPIRecord.setRequest(objectMapper.writeValueAsString(entity));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			rapidAPIRecord.setResponse(response.getBody());
			rapidAPIRecord.setCreatedAt(LocalDateTime.now());
		}
		return rapidAPIRecord;
	}
}
