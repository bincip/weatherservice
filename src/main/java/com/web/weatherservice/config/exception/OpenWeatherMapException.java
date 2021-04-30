package com.web.weatherservice.config.exception;

public class OpenWeatherMapException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OpenWeatherMapException(String message) {
		super(message);
	}

}
