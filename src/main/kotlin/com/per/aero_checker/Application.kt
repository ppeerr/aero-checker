package com.per.aero_checker

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class Application

fun main(args: Array<String>) {
    SpringApplication(Application::class.java).run(*args)
}
