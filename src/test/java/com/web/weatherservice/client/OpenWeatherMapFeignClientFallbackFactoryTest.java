package com.web.weatherservice.client;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.web.weatherservice.config.exception.OpenWeatherMapException;

@ExtendWith(MockitoExtension.class)
public class OpenWeatherMapFeignClientFallbackFactoryTest {

	@InjectMocks
	OpenWeatherMapFeignClientFallbackFactory fallbackFactory;

	@Test
	public void getWeatherByCityTest() {
		assertThrows(OpenWeatherMapException.class, () -> {
			fallbackFactory.create(new Exception("City not Found")).getWeatherByCity("Invalid", "apkKey");
		});

	}

	@Test
	public void getWeatherByLocationTest() {
		assertThrows(OpenWeatherMapException.class, () -> {
			fallbackFactory.create(new Exception("Data not Found")).getWeatherByLocation("Invalid", "data", "apkKey");
		});

	}
}
