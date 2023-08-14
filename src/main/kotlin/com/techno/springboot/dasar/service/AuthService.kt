package com.techno.springboot.dasar.service

import com.techno.springboot.dasar.domain.dto.request.ReqLoginDto
import com.techno.springboot.dasar.domain.dto.request.ReqValidateUser
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto

interface AuthService {
    fun login(reqLoginDto: ReqLoginDto): ResBaseDto <Any>
    fun validateUser(reqValidateUser: ReqValidateUser): ResBaseDto<Any>
}