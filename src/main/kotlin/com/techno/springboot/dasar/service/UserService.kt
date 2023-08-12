package com.techno.springboot.dasar.service

import com.techno.springboot.dasar.domain.dto.request.ReqUserDto
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto
import com.techno.springboot.dasar.domain.dto.response.ResUserDto
import java.util.UUID

interface UserService {
    fun getAll() : ResBaseDto<ArrayList<ResUserDto>>
    fun getById(id: UUID) : ResBaseDto<ResUserDto>
    fun insert(reqUserDto: ReqUserDto): ResBaseDto<Any>
    fun update(reqUserDto: ReqUserDto, id: UUID) : ResBaseDto<Any>
    fun delete(id: UUID) : ResBaseDto<Any>
}