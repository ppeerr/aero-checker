package com.per.aero_checker.controller

import com.per.aero_checker.api.FlightDto
import com.per.aero_checker.service.FlightService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/flight/pulkovo")
@RestController
open class PulkovoFlightController(
        val flightService: FlightService
) {

    @GetMapping("/arrivals")
    fun getPulkovoArrivals() : List<FlightDto>? {
        val pulkovoArrivals = flightService.getPulkovoArrivals()

        return pulkovoArrivals
    }

    @GetMapping("/departures")
    fun getPulkovoDepartures() : List<FlightDto>? {
        val pulkovoDepartures = flightService.getPulkovoDepartures()

        return pulkovoDepartures
    }
}