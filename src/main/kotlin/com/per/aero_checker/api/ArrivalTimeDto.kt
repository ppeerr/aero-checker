package com.per.aero_checker.api

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

class ArrivalTimeDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var scheduled: LocalDateTime? = null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var estimated: LocalDateTime? = null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var actual: LocalDateTime? = null
}