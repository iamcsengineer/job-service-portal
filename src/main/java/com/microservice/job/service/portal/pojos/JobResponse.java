package com.microservice.job.service.portal.pojos;

import java.util.List;

public class JobResponse {
	private String status;
	private String request_id;
	private Parameters parameters;
	private List<Job> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public Parameters getParameters() {
		return parameters;
	}

	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

	public List<Job> getData() {
		return data;
	}

	public void setData(List<Job> data) {
		this.data = data;
	}
}
