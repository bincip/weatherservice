package com.web.weatherservice.service.impl;

/**
 * 
 * Weather Information Service
 * 
 * @author Bincy P
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.web.weatherservice.client.OpenWeatherMapFeignClient;
import com.web.weatherservice.config.exception.OpenWeatherMapException;
import com.web.weatherservice.dto.WeatherResponse;
import com.web.weatherservice.service.WeatherInfoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherInfoServiceImpl implements WeatherInfoService {

	@Autowired
	OpenWeatherMapFeignClient openWeatherMapClient;

	@Value("${service.open-weather-map.api-key}")
	private String applicationKey;

	@Override
	@Cacheable(value = "weather-info-cache", key = "'WeatherInfo'+#city")
	public WeatherResponse weatherInfoByCity(String city) {
		try {
			log.info("Getting weather info from openWeatherMapClient for city:", city);
			return openWeatherMapClient.getWeatherByCity(city, applicationKey);
		} catch (Exception e) {
			throw new OpenWeatherMapException(e.getLocalizedMessage());
		}
	}

	@Override
	@Cacheable(value = "weather-info-cache", key = "'WeatherInfo'+#lat+#lon")
	public WeatherResponse weatherInfoByLocation(String lat, String lon) {
		try {
			log.info("Getting weather info from openWeatherMapClient for lat:{}, lon:{}", lat, lon);

			return openWeatherMapClient.getWeatherByLocation(lat, lon, applicationKey);
		} catch (Exception e) {
			throw new OpenWeatherMapException(e.getMessage());
		}
	}

}
