package com.techno.springboot.dasar.domain.dto.response

import java.util.UUID

data class ResValidateUserDto (
    val id : UUID? = null,
    val email : String? = null,
    val name : String? = null,
    val username : String? = null
)