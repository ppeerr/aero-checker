package com.per.aero_checker.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
open class AppConfiguration {
    @Bean
    open fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}