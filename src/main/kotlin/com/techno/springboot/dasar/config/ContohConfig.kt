package com.techno.springboot.dasar.config

import com.techno.springboot.dasar.service.LogicService
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class ContohConfig(
    private val logicService: LogicService
) {
    @Bean
    fun printName(){
    logicService.printName("alrico rizki wibowo")
    }
    @Bean
    fun getOddsOrEvent() {
        val result = logicService.addOrEvent(9)
        println("Number result is $result")
    }
}