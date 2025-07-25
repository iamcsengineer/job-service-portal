package com.microservice.job.service.portal.pojos;

import java.util.List;

public class JobHighlights {
	private List<String> Qualifications;
	private List<String> Responsibilities;

	public List<String> getQualifications() {
		return Qualifications;
	}

	public void setQualifications(List<String> qualifications) {
		Qualifications = qualifications;
	}

	public List<String> getResponsibilities() {
		return Responsibilities;
	}

	public void setResponsibilities(List<String> responsibilities) {
		Responsibilities = responsibilities;
	}

}
