package com.techno.springboot.dasar.domain.dto.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class ReqLoginDto(
    @field:NotNull(message = "Field Username Not Null")
    @field:NotEmpty(message = "Field Username Not Empty")
    val username : String? = null,

    @field:NotNull(message = "Field Password Not Null")
    @field:NotEmpty(message = "Field Password Not Empty")
    val password : String? = null
)
