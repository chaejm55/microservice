package com.reactive.microservice.chapter2

import com.microservices.chapter2.AdvanceService
import com.microservices.chapter2.ExampleService
import com.microservices.chapter2.ServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
class MicroServiceApplication2 {
    @Bean
    @ConditionalOnExpression("#{'\${service.message.type}'=='simple'}")
    fun exampleService(): ServiceInterface = ExampleService()

    @Bean
    @ConditionalOnExpression("#{'\${service.message.type}'=='advance'}")
    fun advanceService(): ServiceInterface = AdvanceService()
}

@Controller
class FirstController {
    @Autowired
    lateinit var service: ServiceInterface

    @GetMapping("/user/{name}")
    @ResponseBody
    fun hello(@PathVariable name: String) = service.getHello(name)
}

fun main(args: Array<String>) {
    runApplication<MicroServiceApplication2>(*args)
}
