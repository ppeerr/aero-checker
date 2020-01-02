package com.per.aero_checker.service

import com.per.aero_checker.api.FlightDto
import com.per.aero_checker.client.PulkovoClient
import org.springframework.stereotype.Service

@Service
open class FlightService(
        private val pulkovoClient: PulkovoClient
) {

    fun getPulkovoArrivals(): List<FlightDto>? {
        val arrivals = pulkovoClient.getArrivals()

        return arrivals
    }

    fun getPulkovoDepartures(): List<FlightDto>? {
        val departures = pulkovoClient.getDepartures()

        return departures
    }
}