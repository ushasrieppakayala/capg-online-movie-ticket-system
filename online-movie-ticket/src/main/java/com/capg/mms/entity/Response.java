package com.capg.mms.entity;

import java.util.Date;

public class Response {

	private Object data;
	private Date date;

	
	public Response() {
		super();
	}

	public Response(Object data, Date date) {
		super();
		this.data = data;
		this.date = date;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
