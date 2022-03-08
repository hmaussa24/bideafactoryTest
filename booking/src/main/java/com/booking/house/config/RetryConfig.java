package com.booking.house.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.support.RetryTemplate;

import com.booking.house.rest.ApiRetryException;
import com.booking.house.rest.ApiRetryListener;

@Configuration
public class RetryConfig {
	
	@Bean
    public RetryTemplate retryTemplate() {

        return RetryTemplate.builder()
                .maxAttempts(3)
                .fixedBackoff(5000L)
                .retryOn(ApiRetryException.class)
                .withListener(new ApiRetryListener())
                .build();
    }

}
