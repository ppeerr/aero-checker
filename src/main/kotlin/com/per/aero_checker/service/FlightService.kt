package com.per.aero_checker.service

import com.per.aero_checker.api.FlightDto
import com.per.aero_checker.api.SearchCriteria
import com.per.aero_checker.client.PulkovoClient
import com.per.aero_checker.client.PulkovoResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
open class FlightService(
        private val pulkovoClient: PulkovoClient
) {
    private val logger by logger()

    fun getEarliestPulkovoArrivals(): PulkovoResponse {
        val arrivals = retrieveFlights("PulkovoArrivals") { pulkovoClient.getArrivals() }
        arrivals.data = arrivals.data?.subList(0, 10)

        return arrivals
    }

    fun getEarliestPulkovoDepartures(): PulkovoResponse {
        val departures = retrieveFlights("PulkovoDepartures") { pulkovoClient.getDepartures() }
        departures.data = departures.data?.subList(0, 10)

        return departures
    }

    fun searchPulkovoArrivals(criteria: SearchCriteria): PulkovoResponse {
        val arrivals = retrieveFlights("PulkovoArrivals") { pulkovoClient.getArrivals() }
        arrivals.data = arrivals.data?.subList(0, 25)

        arrivals.data = arrivals.data?.asSequence()!!
                .filter { tryToFilterByNumber(it, criteria.number) }
                .filter { tryToFilterByStatus(it, criteria.status) }
                .filter { tryToFilterByCompany(it, criteria.company) }
//                .filter { tryToFilterByFromDateTime(it, criteria.fromDateTime) }
//                .filter { tryToFilterByToDateTime(it, criteria.toDateTime) }
                .toList()

        return arrivals
    }

    fun searchPulkovoDepartures(criteria: SearchCriteria): PulkovoResponse {
        val departures = retrieveFlights("PulkovoDepartures") { pulkovoClient.getDepartures() }
        departures.data = departures.data?.subList(0, 25)

        departures.data = departures.data?.asSequence()!!
                .filter { tryToFilterByNumber(it, criteria.number) }
                .filter { tryToFilterByStatus(it, criteria.status) }
                .filter { tryToFilterByCompany(it, criteria.company) }
//                .filter { tryToFilterByFromDateTime(it, criteria.fromDateTime) }
//                .filter { tryToFilterByToDateTime(it, criteria.toDateTime) }
                .toList()

        return departures
    }

    private fun retrieveFlights(flightType: String, func: Function0<PulkovoResponse>): PulkovoResponse {
        logger.info("get {} started", flightType)
        val start = System.currentTimeMillis()

        val flightResponse = func.invoke()

        logger.info("get {} ended after {}", flightType, System.currentTimeMillis() - start)

        val result = PulkovoResponse()
        result.now = flightResponse.now
        result.data = flightResponse.data!!.toMutableList()

        return result
    }

    private fun tryToFilterByNumber(it: FlightDto, number: String?): Boolean {
        return number == null || it.number == number
    }

    private fun tryToFilterByStatus(it: FlightDto, status: String?): Boolean {
        return status == null || it.status == status
    }

    private fun tryToFilterByCompany(it: FlightDto, company: String?): Boolean {
        return company == null || it.company == company
    }

    private fun tryToFilterByFromDateTime(it: FlightDto, fromDateTime: LocalDateTime?): Boolean {
        return fromDateTime == null || !fromDateTime.isAfter(it.date)
    }

    private fun tryToFilterByToDateTime(it: FlightDto, toDateTime: LocalDateTime?): Boolean {
        return toDateTime == null || !toDateTime.isBefore(it.date)
    }
}

fun <R : Any> R.logger(): Lazy<Logger> {
    return lazy { LoggerFactory.getLogger(this.javaClass) }
}
