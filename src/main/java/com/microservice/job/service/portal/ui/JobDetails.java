package com.microservice.job.service.portal.ui;

public class JobDetails {
	private String jobTitle;
	private String employerName;
	private String employerLogo;
	private String jobEmploymentType;
	private String jobDescription;
	private Boolean jobIsRemote;
	private String jobPostedAt;
	private String jobLocation;
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getEmployerLogo() {
		return employerLogo;
	}
	public void setEmployerLogo(String employerLogo) {
		this.employerLogo = employerLogo;
	}
	public String getJobEmploymentType() {
		return jobEmploymentType;
	}
	public void setJobEmploymentType(String jobEmploymentType) {
		this.jobEmploymentType = jobEmploymentType;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public Boolean getJobIsRemote() {
		return jobIsRemote;
	}
	public void setJobIsRemote(Boolean jobIsRemote) {
		this.jobIsRemote = jobIsRemote;
	}
	public String getJobPostedAt() {
		return jobPostedAt;
	}
	public void setJobPostedAt(String jobPostedAt) {
		this.jobPostedAt = jobPostedAt;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

}
