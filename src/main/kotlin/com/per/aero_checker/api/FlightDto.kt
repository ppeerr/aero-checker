package com.per.aero_checker.api

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

class FlightDto {
    var id: Int? = null
    var day: Int? = null
    var past: Boolean? = null
    var number: String? = null
    var status_en: String? = null
    var status_cn: String? = null
    var status: String? = null
    var company: String? = null
    var airport: String? = null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var date: LocalDateTime? = null
    var arrival_time: ArrivalTimeDto? = null
    var departure_time: ArrivalTimeDto? = null
    var terminal: Int? = null
    var aircraft_type_code: String? = null
    var flight: String? = null
    var now: Boolean? = null
}