package com.per.aero_checker.controller

import com.per.aero_checker.api.SearchCriteria
import com.per.aero_checker.client.pulkovo.PulkovoResponse
import com.per.aero_checker.service.ScheduleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/schedule/pulkovo")
@RestController
open class PulkovoScheduleController(
        private val scheduleService: ScheduleService
) {

    @GetMapping("/arrivals/earliest")
    fun getPulkovoArrivals(): PulkovoResponse {
        return scheduleService.getEarliestPulkovoArrivals()
    }

    @GetMapping("/arrivals/search")
    fun searchPulkovoArrivals(searchCriteria: SearchCriteria): PulkovoResponse {
        return scheduleService.searchPulkovoArrivals(searchCriteria)
    }

    @GetMapping("/departures/earliest")
    fun getPulkovoDepartures(): PulkovoResponse {
        return scheduleService.getEarliestPulkovoDepartures()
    }

    @GetMapping("/departures/search")
    fun searchPulkovoDepartures(criteria: SearchCriteria): PulkovoResponse {
        return scheduleService.searchPulkovoDepartures(criteria)
    }
}
