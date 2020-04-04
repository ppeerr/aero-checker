package com.per.aero_checker.service

import com.per.aero_checker.client.PulkovoClient
import com.per.aero_checker.client.PulkovoResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class FlightService(
        private val pulkovoClient: PulkovoClient
) {
    private val logger by logger()

    fun getPulkovoArrivals(): PulkovoResponse? {
        logger.info("getPulkovoArrivals started")
        val start = System.currentTimeMillis()

        val arrivals = pulkovoClient.getArrivals()

        logger.info("getPulkovoArrivals ended after {}", System.currentTimeMillis() - start)

        arrivals?.data = arrivals?.data?.subList(0, 10)
        return arrivals
    }

    fun getPulkovoDepartures(): PulkovoResponse? {
        logger.info("getPulkovoDepartures started")
        val start = System.currentTimeMillis()

        val departures = pulkovoClient.getDepartures()

        logger.info("getPulkovoDepartures ended after {}", System.currentTimeMillis() - start)

        departures?.data = departures?.data?.subList(0, 10)
        return departures
    }
}

fun <R : Any> R.logger(): Lazy<Logger> {
    return lazy { LoggerFactory.getLogger(this.javaClass) }
}