package com.techno.springboot.dasar.domain.dto.request
import com.techno.springboot.dasar.domain.entity.ProdiEntity
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.*

data class ReqMahasiswaDto(
    @field:NotNull(message = "Nim Not Null")
    val nim : Long? = null,
    @field:NotNull(message = "NNot Null")
    val nama : String? = null,
    @field:NotNull(message = "Gender Not Null")
    val gender : String? = null,
    @field:NotNull(message = "Alamat Not Null")
    val alamat : String? = null,
    @field:NotNull(message = "ID Prodi Not NUll")
    val idProdi : String? = null
)
