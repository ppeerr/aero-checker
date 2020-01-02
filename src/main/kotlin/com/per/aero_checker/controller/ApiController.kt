package com.per.aero_checker.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
open class ApiController {

    @RequestMapping("/hello-world")
    fun hello(): String {
        return "Hello world!"
    }
}