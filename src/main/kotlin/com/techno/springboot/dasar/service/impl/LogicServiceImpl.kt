package com.techno.springboot.dasar.service.impl

import com.techno.springboot.dasar.domain.dto.request.ReqCalculator
import com.techno.springboot.dasar.domain.dto.request.ReqIdentitasDto
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto
import com.techno.springboot.dasar.domain.dto.response.ResCalculator
import com.techno.springboot.dasar.domain.dto.response.ResFullNameDto
import com.techno.springboot.dasar.service.LogicService
import org.springframework.stereotype.Service

@Service
class LogicServiceImpl : LogicService {
    override fun printName(name: String) {
        println("My Name is $name")
    }

    override fun addOrEvent(number: Int): String {
        return if(number % 2==0)
             "Event"
        else
             "Odds"
    }

    override fun fullName(reqIdentitasDto: ReqIdentitasDto): ResBaseDto<ResFullNameDto> {
        val fullNameTemp = reqIdentitasDto.firstName + " " + reqIdentitasDto.lastName
        val resFullName = ResFullNameDto(
            firstName = reqIdentitasDto.firstName,
            lastName = reqIdentitasDto.lastName,
            fullName = fullNameTemp
        )
        return  ResBaseDto(
            data = resFullName
        )

    }

    override fun calculator(operation: String,reqCalculator: ReqCalculator): ResBaseDto<ResCalculator> {
        val result = when (operation) {
            "addition" -> (reqCalculator.valueA ?: 0).toInt() + (reqCalculator.valueB ?: 0).toInt()
            "subtraction" -> (reqCalculator.valueA ?: 0).toInt() - (reqCalculator.valueB ?: 0).toInt()
            "multiple" -> (reqCalculator.valueA ?: 0).toInt() * (reqCalculator.valueB ?: 0).toInt()
            "division" -> (reqCalculator.valueA ?: 0).toFloat() / (reqCalculator.valueB ?: 0).toFloat()
            else -> throw IllegalArgumentException("Invalid operator")
        }
        val resCalculator = ResCalculator(result.toFloat())
        return ResBaseDto(data = resCalculator)
    }
}