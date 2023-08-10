package com.techno.springboot.dasar.service

import com.techno.springboot.dasar.domain.dto.request.ReqCalculator
import com.techno.springboot.dasar.domain.dto.request.ReqIdentitasDto
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto
import com.techno.springboot.dasar.domain.dto.response.ResCalculator
import com.techno.springboot.dasar.domain.dto.response.ResFullNameDto

interface LogicService {
    fun printName(name : String)
    fun addOrEvent(number: Int) : String
    fun fullName(reqIdentitasDto: ReqIdentitasDto): ResBaseDto<ResFullNameDto>
    fun calculator(operation: String,reqCalculator: ReqCalculator): ResBaseDto<ResCalculator>

}