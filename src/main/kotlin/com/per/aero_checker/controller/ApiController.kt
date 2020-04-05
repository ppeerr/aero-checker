package com.per.aero_checker.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
open class ApiController {

    @GetMapping("/hello-world")
    fun hello(): String {
        return "Hello world!"
    }
}
