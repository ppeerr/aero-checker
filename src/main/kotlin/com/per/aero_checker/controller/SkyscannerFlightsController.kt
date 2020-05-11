package com.per.aero_checker.controller

import com.per.aero_checker.client.skyscanner.api.PlacesResponse
import com.per.aero_checker.service.FlightService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/flight/skyscanner")
@RestController
open class SkyscannerFlightsController(
        private val flightService: FlightService
) {

    @GetMapping("/places")
    fun getPlaces(query: String) : PlacesResponse {
        return flightService.getSkyscannerPlaces(query)
    }
}
