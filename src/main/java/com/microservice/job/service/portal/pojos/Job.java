package com.microservice.job.service.portal.pojos;

import java.util.List;

public class Job {
	private String job_id;
	private String job_title;
	private String employer_name;
	private String employer_logo;
	private String employer_website;
	private String job_publisher;
	private String job_employment_type;
	private List<String> job_employment_types;
	private String job_apply_link;
	private boolean job_apply_is_direct;
	private List<ApplyOption> apply_options;
	private String job_description;
	private boolean job_is_remote;
	private String job_posted_at;
	private long job_posted_at_timestamp;
	private String job_posted_at_datetime_utc;
	private String job_location;
	private String job_city;
	private String job_state;
	private String job_country;
	private double job_latitude;
	private double job_longitude;
	private String job_benefits;
	private String job_google_link;
	private String job_salary;
	private String job_min_salary;
	private String job_max_salary;
	private String job_salary_period;
	private JobHighlights job_highlights;
	private String job_onet_soc;
	private String job_onet_job_zone;

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getEmployer_name() {
		return employer_name;
	}

	public void setEmployer_name(String employer_name) {
		this.employer_name = employer_name;
	}

	public String getEmployer_logo() {
		return employer_logo;
	}

	public void setEmployer_logo(String employer_logo) {
		this.employer_logo = employer_logo;
	}

	public String getEmployer_website() {
		return employer_website;
	}

	public void setEmployer_website(String employer_website) {
		this.employer_website = employer_website;
	}

	public String getJob_publisher() {
		return job_publisher;
	}

	public void setJob_publisher(String job_publisher) {
		this.job_publisher = job_publisher;
	}

	public String getJob_employment_type() {
		return job_employment_type;
	}

	public void setJob_employment_type(String job_employment_type) {
		this.job_employment_type = job_employment_type;
	}

	public List<String> getJob_employment_types() {
		return job_employment_types;
	}

	public void setJob_employment_types(List<String> job_employment_types) {
		this.job_employment_types = job_employment_types;
	}

	public String getJob_apply_link() {
		return job_apply_link;
	}

	public void setJob_apply_link(String job_apply_link) {
		this.job_apply_link = job_apply_link;
	}

	public boolean isJob_apply_is_direct() {
		return job_apply_is_direct;
	}

	public void setJob_apply_is_direct(boolean job_apply_is_direct) {
		this.job_apply_is_direct = job_apply_is_direct;
	}

	public List<ApplyOption> getApply_options() {
		return apply_options;
	}

	public void setApply_options(List<ApplyOption> apply_options) {
		this.apply_options = apply_options;
	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	public boolean isJob_is_remote() {
		return job_is_remote;
	}

	public void setJob_is_remote(boolean job_is_remote) {
		this.job_is_remote = job_is_remote;
	}

	public String getJob_posted_at() {
		return job_posted_at;
	}

	public void setJob_posted_at(String job_posted_at) {
		this.job_posted_at = job_posted_at;
	}

	public long getJob_posted_at_timestamp() {
		return job_posted_at_timestamp;
	}

	public void setJob_posted_at_timestamp(long job_posted_at_timestamp) {
		this.job_posted_at_timestamp = job_posted_at_timestamp;
	}

	public String getJob_posted_at_datetime_utc() {
		return job_posted_at_datetime_utc;
	}

	public void setJob_posted_at_datetime_utc(String job_posted_at_datetime_utc) {
		this.job_posted_at_datetime_utc = job_posted_at_datetime_utc;
	}

	public String getJob_location() {
		return job_location;
	}

	public void setJob_location(String job_location) {
		this.job_location = job_location;
	}

	public String getJob_city() {
		return job_city;
	}

	public void setJob_city(String job_city) {
		this.job_city = job_city;
	}

	public String getJob_state() {
		return job_state;
	}

	public void setJob_state(String job_state) {
		this.job_state = job_state;
	}

	public String getJob_country() {
		return job_country;
	}

	public void setJob_country(String job_country) {
		this.job_country = job_country;
	}

	public double getJob_latitude() {
		return job_latitude;
	}

	public void setJob_latitude(double job_latitude) {
		this.job_latitude = job_latitude;
	}

	public double getJob_longitude() {
		return job_longitude;
	}

	public void setJob_longitude(double job_longitude) {
		this.job_longitude = job_longitude;
	}

	public String getJob_benefits() {
		return job_benefits;
	}

	public void setJob_benefits(String job_benefits) {
		this.job_benefits = job_benefits;
	}

	public String getJob_google_link() {
		return job_google_link;
	}

	public void setJob_google_link(String job_google_link) {
		this.job_google_link = job_google_link;
	}

	public String getJob_salary() {
		return job_salary;
	}

	public void setJob_salary(String job_salary) {
		this.job_salary = job_salary;
	}

	public String getJob_min_salary() {
		return job_min_salary;
	}

	public void setJob_min_salary(String job_min_salary) {
		this.job_min_salary = job_min_salary;
	}

	public String getJob_max_salary() {
		return job_max_salary;
	}

	public void setJob_max_salary(String job_max_salary) {
		this.job_max_salary = job_max_salary;
	}

	public String getJob_salary_period() {
		return job_salary_period;
	}

	public void setJob_salary_period(String job_salary_period) {
		this.job_salary_period = job_salary_period;
	}

	public JobHighlights getJob_highlights() {
		return job_highlights;
	}

	public void setJob_highlights(JobHighlights job_highlights) {
		this.job_highlights = job_highlights;
	}

	public String getJob_onet_soc() {
		return job_onet_soc;
	}

	public void setJob_onet_soc(String job_onet_soc) {
		this.job_onet_soc = job_onet_soc;
	}

	public String getJob_onet_job_zone() {
		return job_onet_job_zone;
	}

	public void setJob_onet_job_zone(String job_onet_job_zone) {
		this.job_onet_job_zone = job_onet_job_zone;
	}
}

