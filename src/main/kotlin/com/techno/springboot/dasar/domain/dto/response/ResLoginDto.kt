package com.techno.springboot.dasar.domain.dto.response

import java.util.UUID

data class ResLoginDto(
    val uuid: UUID? = null,
    val token: String? = null,
)
