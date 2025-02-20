package com.maybanktask.user_management.commonconfig;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if (authentication != null && authentication.getCredentials() != null) {
                    String token = (String) authentication.getCredentials();
                    template.header("Authorization", "Bearer " + token);
                }
            }
        };
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 60000); // 5 seconds connect timeout, 30 seconds read timeout

    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;

    }
}