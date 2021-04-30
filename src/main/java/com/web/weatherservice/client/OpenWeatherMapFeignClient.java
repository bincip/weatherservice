package com.web.weatherservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.weatherservice.dto.WeatherResponse;

@FeignClient(name = "openWeatherMapFeignClient", url = "${service.open-weather-map.url}", 
					fallbackFactory = OpenWeatherMapFeignClientFallbackFactory.class)
public interface OpenWeatherMapFeignClient {

	@GetMapping(value = "/data/2.5/weather", produces = "application/json")
	WeatherResponse getWeatherByCity(@RequestParam("q") String city, @RequestParam("appid") String applicationKey);

	@GetMapping(value = "/data/2.5/weather", produces = "application/json")
	WeatherResponse getWeatherByLocation(@RequestParam("lat") String lat, @RequestParam("lon") String lon,
			@RequestParam("appid") String applicationKey);
}
