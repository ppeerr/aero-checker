package com.per.aero_checker

import com.per.aero_checker.configuration.AirportConfig
import com.per.aero_checker.configuration.FlightSystemsConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

@EnableConfigurationProperties(value = [
    AirportConfig::class,
    FlightSystemsConfig::class
])
@SpringBootApplication
open class Application

fun main(args: Array<String>) {
    SpringApplication(Application::class.java).run(*args)
}
