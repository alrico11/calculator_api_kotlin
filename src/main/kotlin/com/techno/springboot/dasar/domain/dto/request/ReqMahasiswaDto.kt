package com.techno.springboot.dasar.domain.dto.request

import java.util.*

data class ReqMahasiswaDto(
    val nim : Long? = null,
    val nama : String? = null,
    val gender : String? = null,
    val alamat : String? = null,
    val idProdi : String? = null
)
