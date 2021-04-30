package com.web.weatherservice.service;

import com.web.weatherservice.dto.WeatherResponse;

public interface WeatherInfoService {

	WeatherResponse weatherInfoByCity(String city);

	WeatherResponse weatherInfoByLocation(String lat, String lon);
	
}
