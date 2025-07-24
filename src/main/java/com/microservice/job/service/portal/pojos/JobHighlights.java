package com.microservice.job.service.portal.pojos;

import java.util.List;

public class JobHighlights {
	private List<String> qualifications;
	private List<String> responsibilities;

	public List<String> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<String> qualifications) {
		this.qualifications = qualifications;
	}

	public List<String> getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(List<String> responsibilities) {
		this.responsibilities = responsibilities;
	}

}
