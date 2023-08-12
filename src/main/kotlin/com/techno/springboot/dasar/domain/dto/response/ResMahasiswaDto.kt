package com.techno.springboot.dasar.domain.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResMahasiswaDto(
    @field:JsonProperty(value = "nim")
    val nim : Long,
    @field:JsonProperty(value = "nama")
    val nama : String,
    @field:JsonProperty(value = "gender")
    val gender : String,
    @field:JsonProperty(value = "alamat")
    val alamat : String,
    @field:JsonProperty(value = "jurusan")
    val jurusan : String
)
