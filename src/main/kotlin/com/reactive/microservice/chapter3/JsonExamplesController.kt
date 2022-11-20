package com.reactive.microservice.chapter3

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JsonExamplesController {
    @GetMapping("/json")
    fun getJson() = ComplexObject(object1 = SimpleObject("more", "complex"))
}