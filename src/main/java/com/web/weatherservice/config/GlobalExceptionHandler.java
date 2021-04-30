package com.web.weatherservice.config;

/**
 * 
 * Exception handler
 * 
 * @author Bincy P
 *
 */

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.web.weatherservice.config.exception.OpenWeatherMapException;
import com.web.weatherservice.dto.ErrorDto;

@ControllerAdvice
public class GlobalExceptionHandler {

	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ OpenWeatherMapException.class })
	public @ResponseBody ErrorDto handleOpenWeatherMapException(OpenWeatherMapException e) {
		String errorlogId = UUID.randomUUID().toString();

		ErrorDto errorDto = new ErrorDto();
		errorDto.setMessage(e.getMessage());
		errorDto.setErrorlogId(errorlogId);

		return errorDto;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ Exception.class })
	public @ResponseBody ErrorDto handleException(Exception e) {
		String errorlogId = UUID.randomUUID().toString();

		ErrorDto errorDto = new ErrorDto();
		errorDto.setMessage(e.getMessage());
		errorDto.setErrorlogId(errorlogId);

		return errorDto;
	}
	
	

}
