package com.per.aero_checker

import com.per.aero_checker.configuration.AirportConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cache.annotation.EnableCaching

@EnableConfigurationProperties(value = [AirportConfig::class])
@SpringBootApplication
open class Application

fun main(args: Array<String>) {
    SpringApplication(Application::class.java).run(*args)
}
