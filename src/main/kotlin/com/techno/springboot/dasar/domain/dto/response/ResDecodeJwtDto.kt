package com.techno.springboot.dasar.domain.dto.response

import java.sql.Date

data class ResDecodeJwtDto(
    val id : Int? = null,
    val username : String? = null,
    val exp : String? = null
)
