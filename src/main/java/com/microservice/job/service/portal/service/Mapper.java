package com.microservice.job.service.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.job.service.portal.pojos.JobResponse;

@Component
public class Mapper {

	@Autowired
	private ObjectMapper objectMapper;

	public JobResponse convertJsonToJobResponse(String response) {
		// Convert External API Json Object to JobResponse Objects.
		JobResponse jobResponse = null;
		try {
			jobResponse = objectMapper.readValue(response, JobResponse.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jobResponse;
	}
}
