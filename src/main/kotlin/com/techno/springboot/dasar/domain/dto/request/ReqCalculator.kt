package com.techno.springboot.dasar.domain.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

data class ReqCalculator(
    @field:JsonProperty(value = "value_a")
    val valueA: Float? = null,
    @field:JsonProperty(value = "value_b")
    val valueB: Float? = null
)
