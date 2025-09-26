package com.microservice.job.service.portal.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.job.service.portal.pojos.Job;
import com.microservice.job.service.portal.pojos.JobResponse;
import com.microservice.job.service.portal.ui.JobDetails;
import com.microservice.job.service.portal.ui.JobPortal;

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

	public JobPortal convertJobResponseToJobPortal(JobResponse jobResponse) {
		JobPortal jobPortal = new JobPortal();

		List<JobDetails> jobDetailsList = jobResponse.getData().stream().map(job -> {
			JobDetails jobDetails = new JobDetails();
			jobDetails.setJobId(job.getJob_id());
			jobDetails.setJobTitle(job.getJob_title());
			jobDetails.setEmployerName(job.getEmployer_name());
			jobDetails.setEmployerLogo(job.getEmployer_logo());
			jobDetails.setJobPublisher(job.getJob_publisher());
			jobDetails.setJobEmploymentType(job.getJob_employment_type());
			jobDetails.setJobApplyLink(job.getJob_apply_link());
			jobDetails.setJobDescription(job.getJob_description());
			jobDetails.setJobIsRemote(job.isJob_is_remote());
			jobDetails.setJobPostedAt(job.getJob_posted_at());
			jobDetails.setJobLocation(job.getJob_location());
			return jobDetails;
		}).collect(Collectors.toList());

		jobPortal.setJobDetails(jobDetailsList);
		return jobPortal;
	}

	public JobResponse combineRemoteJobObjectsWithNonRemoteJob(JobResponse jobResponse1, JobResponse jobResponse2) {
		jobResponse1.getData().addAll(jobResponse2.getData());
		return jobResponse1;
	}
	
	public String convertJavaToJson(JobResponse JobResponse) throws JsonProcessingException {
		return objectMapper.writeValueAsString(JobResponse);
	}

}
