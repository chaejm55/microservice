package com.reactive.microservice.chapter3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class MicroserviceApplication3

fun main(args: Array<String>) {
    runApplication<MicroserviceApplication3>(*args)
}
