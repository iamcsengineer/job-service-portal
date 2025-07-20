package com.microservice.job.service.portal.api.clients;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.microservice.job.service.portal.entities.RapidAPIRecord;

@Component
public class RapidApiClient {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${job-service-portal.base.url}")
	private String baseUrl;

	public RapidAPIRecord callJobPortalExternalAPI() {
		// Build dynamic URI
		URI uri = UriComponentsBuilder.fromUriString(baseUrl).queryParam("query", "developer jobs in india")
				.queryParam("page", 1).queryParam("num_pages", 1).queryParam("country", "india")
				.queryParam("date_posted", "all").build().encode().toUri();
		// Set headers
		HttpHeaders headers = new HttpHeaders();
		headers.set("x-rapidapi-host", "jsearch.p.rapidapi.com");
		headers.set("x-rapidapi-key", "b1a0f614c3msh48f7046e1a99479p1e8f38jsn6732fc436e54");

		HttpEntity<String> entity = new HttpEntity<>(headers);

		// Make the GET request
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		RapidAPIRecord rapidAPIRecord = new RapidAPIRecord();
		if(response.getBody()!=null) {
			rapidAPIRecord.setRequest(null);
			rapidAPIRecord.setResponse(response.getBody());
		}
		return rapidAPIRecord;
	}
}
