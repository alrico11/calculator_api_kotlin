package com.techno.springboot.dasar.domain.dto.response

data class ResBaseDto<T>(
    val status : Boolean = true,
    val message : String = "success",
    val data :  T? = null
)
