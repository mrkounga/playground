package com.rodatek.common.web.exception;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ApiError {

	private LocalDateTime timeStamp;
    private int status;
    private String message;
    private String developerMessage;

    public ApiError(final LocalDateTime timeStamp, final int status, final String message, final String developerMessage) {
    	this.timeStamp=timeStamp;
        this.status = status;
        this.message = message;
        this.developerMessage = developerMessage;
    }

    //

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(final String developerMessage) {
        this.developerMessage = developerMessage;
    }

    
    
    //

  

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
    public final String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ApiError [timeStamp=").append(timeStamp).append(", status=").append(status).append(", message=").append(message).append(", developerMessage=").append(developerMessage).append("]");
        return builder.toString();
    }

}
