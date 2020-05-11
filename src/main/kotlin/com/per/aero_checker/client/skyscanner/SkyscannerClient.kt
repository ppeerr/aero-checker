package com.per.aero_checker.client.skyscanner

import com.fasterxml.jackson.databind.ObjectMapper
import com.per.aero_checker.client.skyscanner.api.PlacesResponse
import com.per.aero_checker.configuration.CacheConfiguration
import com.per.aero_checker.configuration.FlightSystemsConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
open class SkyscannerClient(
        private val flightSystemsConfig: FlightSystemsConfig,
        private val restTemplate: RestTemplate,
        private val objectMapper: ObjectMapper
) {

    @Cacheable(CacheConfiguration.CACHE_THREE)
    open fun getPlaces(query: String): PlacesResponse {
        val url = flightSystemsConfig.skyscanner.url
        val version = flightSystemsConfig.skyscanner.version

        val finalUrl = "$url/$PLACES_PATH/$version/$COUNTRY/$CURRENCY/$LANGUAGE/?query=$query"
        val body = restTemplate
                .exchange(
                        finalUrl,
                        HttpMethod.GET,
                        getRequest(),
                        String::class.java)
                .body

        return objectMapper.readValue(body, PlacesResponse::class.java)
    }


    private fun getRequest(): HttpEntity<*> {
        val headers = HttpHeaders()
        headers.set("x-rapidapi-host", flightSystemsConfig.skyscanner.rapidApiHost)
        headers.set("x-rapidapi-key", flightSystemsConfig.skyscanner.rapidApiKey)

        return HttpEntity<Any?>(headers)
    }

    companion object {
        const val PLACES_PATH = "autosuggest"

        const val COUNTRY = "RU"
        const val CURRENCY = "RUB"
        const val LANGUAGE = "ru-RU"
    }
}
