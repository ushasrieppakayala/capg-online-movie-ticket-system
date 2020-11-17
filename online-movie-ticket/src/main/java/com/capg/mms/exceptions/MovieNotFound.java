package com.capg.mms.exceptions;

public class MovieNotFound extends RuntimeException{

	public MovieNotFound(String msg) {
		
		super(msg);
	}
}