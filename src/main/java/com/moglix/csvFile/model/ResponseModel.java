package com.moglix.csvFile.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseModel<T> {
	private Boolean status;
	private int statusCode;
	private String statusDescription;
	private T data;

	@JsonCreator
	public ResponseModel(@JsonProperty("status")Boolean status,@JsonProperty("statusCode") int statusCode,@JsonProperty("statusDescription") String statusDescription,@JsonProperty("data") T data) {
	super();
	this.status = status;
	this.statusCode = statusCode;
	this.statusDescription = statusDescription;
	this.data = data;
	}


	public ResponseModel(boolean status, int statusCode, T data) {
	super();
	        this.status = status;
	        this.statusCode = statusCode;
	        this.data = data;
	    }

		public ResponseModel(T data) {
			this(true, data);
		}

		public ResponseModel(boolean status, T data) {
			this(status, 200, data);
		}

		public Boolean getStatus() {
			return status;
		}

		public void setStatus(Boolean status) {
			this.status = status;
		}

		public int getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}

		public String getStatusDescription() {
			return statusDescription;
		}

		public void setStatusDescription(String statusDescription) {
			this.statusDescription = statusDescription;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "ResponseModel [statusCode=" + statusCode + ", statusMsg=" + statusDescription + ", data=" + data
					+ "]";
		}

	}
