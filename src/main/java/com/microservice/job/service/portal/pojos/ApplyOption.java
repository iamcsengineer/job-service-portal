package com.microservice.job.service.portal.pojos;

public class ApplyOption {
	private String publisher;
	private String apply_link;
	private boolean is_direct;

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getApply_link() {
		return apply_link;
	}

	public void setApply_link(String apply_link) {
		this.apply_link = apply_link;
	}

	public boolean isIs_direct() {
		return is_direct;
	}

	public void setIs_direct(boolean is_direct) {
		this.is_direct = is_direct;
	}
}
