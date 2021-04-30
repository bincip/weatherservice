package com.web.weatherservice.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;

@Configuration
@EnableCaching
public class WeatherCacheConfiguration extends CachingConfigurerSupport {


	@Bean
	public net.sf.ehcache.CacheManager ehCacheManager() {
		CacheConfiguration weatherInfoCache = new CacheConfiguration();
		weatherInfoCache.setName("weather-info-cache");
		weatherInfoCache.setMemoryStoreEvictionPolicy("LRU");
		weatherInfoCache.setMaxEntriesLocalHeap(1000);
		weatherInfoCache.setTimeToLiveSeconds(7200);

		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
		config.addCache(weatherInfoCache);
		return net.sf.ehcache.CacheManager.newInstance(config);
	}

	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}
}