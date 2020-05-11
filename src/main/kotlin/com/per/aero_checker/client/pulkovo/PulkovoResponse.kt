package com.per.aero_checker.client.pulkovo

import com.fasterxml.jackson.annotation.JsonFormat
import com.per.aero_checker.api.FlightDto
import java.time.LocalDateTime

class PulkovoResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var now: LocalDateTime? = null
    var data: List<FlightDto>? = null
}
