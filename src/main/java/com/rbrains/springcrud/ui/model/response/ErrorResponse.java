package com.rbrains.springcrud.ui.model.response;

import java.util.Date;

public class ErrorResponse {
	private Date timesStamp;
	private String message;
	
	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public ErrorResponse(Date timesStamp, String message) {
		super();
		this.timesStamp = timesStamp;
		this.message = message;
	}

	public Date getTimesStamp() {
		return timesStamp;
	}
	public void setTimesStamp(Date timesStamp) {
		this.timesStamp = timesStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
