package com.per.aero_checker.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "flights")
data class FlightSystemsConfig(
        val skyscanner: FlightSystem = FlightSystem()
)

data class FlightSystem(
        var version: String? = null,
        var url: String? = null,
        var rapidApiHost: String? = null,
        var rapidApiKey: String? = null
)
