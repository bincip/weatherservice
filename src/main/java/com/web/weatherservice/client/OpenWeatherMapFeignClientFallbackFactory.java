package com.web.weatherservice.client;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.web.weatherservice.config.exception.OpenWeatherMapException;
import com.web.weatherservice.dto.WeatherResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OpenWeatherMapFeignClientFallbackFactory implements FallbackFactory<OpenWeatherMapFeignClient> {

	@Override
	public OpenWeatherMapFeignClient create(Throwable throwable) {
		return new OpenWeatherMapFeignClient() {
			@Override
			public WeatherResponse getWeatherByCity(String city, String applicationKey) {
				log.error("Inside fallback for getWeatherByCity() due to error {}", throwable.getLocalizedMessage());
				throw new OpenWeatherMapException( throwable.getLocalizedMessage());
		
			}

			@Override
			public WeatherResponse getWeatherByLocation(String lat, String lon, String applicationKey) {
				log.error("Inside fallback for getWeatherByCity() due to error {}", throwable.getLocalizedMessage());
				throw new OpenWeatherMapException( throwable.getLocalizedMessage());
			}
		};
	}
}
