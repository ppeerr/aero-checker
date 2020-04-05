package com.per.aero_checker.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.per.aero_checker.configuration.AirportConfig
import com.per.aero_checker.configuration.CacheConfiguration
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
open class PulkovoClient(
        private val airportConfig: AirportConfig,
        private val restTemplate: RestTemplate,
        private val objectMapper: ObjectMapper
) {

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
