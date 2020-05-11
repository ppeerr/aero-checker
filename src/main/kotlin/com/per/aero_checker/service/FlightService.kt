package com.per.aero_checker.service

import com.per.aero_checker.client.skyscanner.SkyscannerClient
import com.per.aero_checker.client.skyscanner.api.PlacesResponse
import org.springframework.stereotype.Service

@Service
open class FlightService(
        private val skyscannerClient: SkyscannerClient
) {
    private val logger by logger()

    fun getSkyscannerPlaces(query: String): PlacesResponse {
        logger.info("get Skyscanner Places started")
        val start = System.currentTimeMillis()

        val places = skyscannerClient.getPlaces(query)

        logger.info("get Skyscanner Places ended after {}", System.currentTimeMillis() - start)
        return places
    }
}
