package com.techno.springboot.dasar.domain.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class ResUserDto(
    @field:JsonProperty(value = "")
    val id: UUID? = null,
    @field:JsonProperty(value = "")
    val name: String? = null,
    @field:JsonProperty(value = "")
    val username: String? = null,
    @field:JsonProperty(value = "")
    val email: String? = null,
    @field:JsonProperty(value = "")
    val password: String? = null
)
