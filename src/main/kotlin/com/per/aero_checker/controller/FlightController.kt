package com.per.aero_checker.controller

import com.per.aero_checker.api.SearchCriteria
import com.per.aero_checker.client.PulkovoResponse
import com.per.aero_checker.service.FlightService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/flight/pulkovo")
@RestController
open class PulkovoFlightController(
        val flightService: FlightService
) {

    @GetMapping("/arrivals/earliest")
    fun getPulkovoArrivals(): PulkovoResponse {
        return flightService.getEarliestPulkovoArrivals()
    }

    @GetMapping("/arrivals/search")
    fun searchPulkovoArrivals(searchCriteria: SearchCriteria): PulkovoResponse {
        return flightService.searchPulkovoArrivals(searchCriteria)
    }

    @GetMapping("/departures/earliest")
    fun getPulkovoDepartures(): PulkovoResponse {
        return flightService.getEarliestPulkovoDepartures()
    }

    @GetMapping("/departures/search")
    fun searchPulkovoDepartures(criteria: SearchCriteria): PulkovoResponse {
        return flightService.searchPulkovoDepartures(criteria)
    }
}
