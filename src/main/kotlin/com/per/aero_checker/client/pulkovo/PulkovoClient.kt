package com.per.aero_checker.client.pulkovo

import com.fasterxml.jackson.databind.ObjectMapper
import com.per.aero_checker.configuration.AirportConfig
import com.per.aero_checker.configuration.CacheConfiguration
import com.per.aero_checker.service.logger
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
open class PulkovoClient(
        private val airportConfig: AirportConfig,
        private val restTemplate: RestTemplate,
        private val objectMapper: ObjectMapper
) {
    private val logger by logger()

    @Cacheable(CacheConfiguration.CACHE_ONE)
    open fun getArrivals(): PulkovoResponse {
        return getSortedResponse(airportConfig.pulkovo.arrives!!)
    }

    @Cacheable(CacheConfiguration.CACHE_TWO)
    open fun getDepartures(): PulkovoResponse {
        return getSortedResponse(airportConfig.pulkovo.departures!!)
    }

    private fun getSortedResponse(url: String): PulkovoResponse {
        val body = restTemplate
                .getForEntity(
                        url,
                        String::class.java)
                .body

        val response = objectMapper.readValue(body, PulkovoResponse::class.java)
        response.data = response.data!!.sortedBy { it.date }

        return response
    }
}
