package com.web.weatherservice.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.web.weatherservice.dto.WeatherResponse;
import com.web.weatherservice.service.WeatherInfoService;

@ExtendWith(MockitoExtension.class)
public class WeatherInfoControllerTest {
	
	@InjectMocks
	private WeatherInfoController weatherInfoController;

	@Mock
	WeatherInfoService weatherInfoService;

	@Test
	public void weatherInfoByCityTest() {
		when(weatherInfoService.weatherInfoByCity("London")).thenReturn(getWeatherResponse());
		WeatherResponse response = weatherInfoController.weatherInfoByCity("London");
		assertNotNull(response);
	}
	
	@Test
	public void weatherInfoByCityAndContryTest() {
		when(weatherInfoService.weatherInfoByCity("London,UK")).thenReturn(getWeatherResponse());
		WeatherResponse response = weatherInfoController.weatherInfoByCityAndContry("London","UK");
		assertNotNull(response);
	}
	
	@Test
	public void weatherInfoByLocationTest() {
		when(weatherInfoService.weatherInfoByLocation("39","135")).thenReturn(getWeatherResponse());
		WeatherResponse response = weatherInfoController.weatherInfoByLocation("39","135");
		assertNotNull(response);
	}

	private WeatherResponse getWeatherResponse() {
		WeatherResponse response = new WeatherResponse();
		return response;
	}

}
