package com.per.aero_checker.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "airport")
data class AirportConfig(
        val pulkovo: FlightConfig = FlightConfig()
)

data class FlightConfig (
    var departures: String ?= null,
    var arrives: String ?= null
)