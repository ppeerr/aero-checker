package com.per.aero_checker.service

import com.per.aero_checker.api.FlightDto
import com.per.aero_checker.client.PulkovoClient
import com.per.aero_checker.client.PulkovoResponse
import org.springframework.stereotype.Service

@Service
open class FlightService(
        private val pulkovoClient: PulkovoClient
) {

    fun getPulkovoArrivals(): PulkovoResponse? {
        val arrivals = pulkovoClient.getArrivals()
        arrivals?.data = arrivals?.data?.subList(0, 10)

        return arrivals
    }

    fun getPulkovoDepartures(): PulkovoResponse? {
        val departures = pulkovoClient.getDepartures()
        departures?.data = departures?.data?.subList(0, 10)

        return departures
    }
}