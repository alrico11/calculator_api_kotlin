package com.techno.springboot.dasar.domain.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResFullNameDto(
    @field:JsonProperty(value = "first_name")
    val firstName : String? = null,
    @field:JsonProperty(value = "last_name")
    val lastName : String? = null,
    @field:JsonProperty(value = "full_name")
    val fullName : String? = null,
)
