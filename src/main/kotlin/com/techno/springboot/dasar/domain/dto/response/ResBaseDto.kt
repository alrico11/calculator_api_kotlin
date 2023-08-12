package com.techno.springboot.dasar.domain.dto.response

data class ResBaseDto<T>(
    val status : Boolean = true,
    val message : String = "success",
    val data :  T? = null,
    val code : Int? = 200,
   // val errors : List<String>? = null
    val errors : T? = null
)
