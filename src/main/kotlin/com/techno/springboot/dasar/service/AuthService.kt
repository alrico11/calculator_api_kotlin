package com.techno.springboot.dasar.service

import com.techno.springboot.dasar.domain.dto.request.ReqDecodeJwtDto
import com.techno.springboot.dasar.domain.dto.request.ReqLoginDto
import com.techno.springboot.dasar.domain.dto.request.ReqValidateUserDto
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto

interface AuthService {
    fun login(reqLoginDto: ReqLoginDto): ResBaseDto <Any>
    fun validateUser(reqValidateUserDto: ReqValidateUserDto): ResBaseDto<Any>

    fun validateToken(auth: String): Boolean

}