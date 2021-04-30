package com.web.weatherservice.controller;

/**
 * 
 * Weather Information Controller
 * 
 * @author Bincy P
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.weatherservice.dto.WeatherResponse;
import com.web.weatherservice.service.WeatherInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "Weather Information Service" })
@RestController
@RequestMapping("/api/weather-info")
public class WeatherInfoController {

	@Autowired
	WeatherInfoService weatherInfoService;

	@ApiOperation(value = "Gets weather information By City", notes = "", produces = "application/json", response = Boolean.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully retrieved the weather information"),
			@ApiResponse(code = 404, message = "Data not found for the city."),
			@ApiResponse(code = 400, message = "Bad Request."), })
	@GetMapping("/by-city/{city}")
	public WeatherResponse weatherInfoByCity(@PathVariable String city) {
		return weatherInfoService.weatherInfoByCity(city);
	}

	@ApiOperation(value = "Gets weather information By City and Country, use ISO 3166 country codes", notes = "", produces = "application/json", response = Boolean.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully retrieved the weather information"),
			@ApiResponse(code = 404, message = "Data not found for the City/Country."),
			@ApiResponse(code = 400, message = "Bad Request."), })
	@GetMapping("/by-city/{city}/{country}")
	public WeatherResponse weatherInfoByCityAndContry(@PathVariable String city, @PathVariable String country) {

		city = city + "," + country;
		return weatherInfoService.weatherInfoByCity(city);
	}

	@ApiOperation(value = "Gets weather information By polar coordinates", notes = "", produces = "application/json", response = Boolean.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully retrieved the weather information"),
			@ApiResponse(code = 404, message = "Data not found for the polar coordinates."),
			@ApiResponse(code = 400, message = "Bad Request."), })
	@GetMapping("/by-location/{lat}/{lon}")
	public WeatherResponse weatherInfoByLocation(@PathVariable String lat, @PathVariable String lon) {
		return weatherInfoService.weatherInfoByLocation(lat, lon);
	}
}
