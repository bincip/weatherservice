package com.web.weatherservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.web.weatherservice.client.OpenWeatherMapFeignClient;
import com.web.weatherservice.dto.WeatherResponse;

@ExtendWith(MockitoExtension.class)
public class WeatherInfoServiceImplTest  {
	
	@InjectMocks
	private WeatherInfoServiceImpl weatherInfoService;

	@Mock
	OpenWeatherMapFeignClient openWeatherMapClient;

	@BeforeEach
	public void setUp() {
		ReflectionTestUtils.setField(weatherInfoService, "applicationKey", "ffa6f13ea40a22452bba3be726315d3f");
	}
	
	@Test
	public void weatherInfoByCityTest() {
		when(openWeatherMapClient.getWeatherByCity("London","ffa6f13ea40a22452bba3be726315d3f")).thenReturn(getWeatherResponse());
		WeatherResponse response = weatherInfoService.weatherInfoByCity("London");
		assertNotNull(response);
	}

	@Test
	public void weatherInfoByLocationTest() {
		when(openWeatherMapClient.getWeatherByLocation("35", "139", "ffa6f13ea40a22452bba3be726315d3f")).thenReturn(getWeatherResponse());
		WeatherResponse response = weatherInfoService.weatherInfoByLocation("35", "139");
		assertNotNull(response);
	}
	
	private WeatherResponse getWeatherResponse() {
		WeatherResponse response = new WeatherResponse();
		return response;
	}

}
