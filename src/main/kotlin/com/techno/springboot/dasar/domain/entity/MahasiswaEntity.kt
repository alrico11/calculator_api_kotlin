package com.techno.springboot.dasar.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.*
@Entity
@Table(name = "mahasiswa")
data class MahasiswaEntity(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.SEQUENCE)
    @field:Column(name = "", columnDefinition = "bigint")
    val id : Long? = null,
    @field:Column(name = "", columnDefinition = "bigint")
    val nim : Long? = null,
    @field:Column(name = "", columnDefinition = "varchar(100)")
    val nama : String? = null,
    @field:Column(name = "", columnDefinition = "varchar(100)")
    val gender : String? = null,
    @field:Column(name = "", columnDefinition = "text")
    val alamat : String? = null,
    @ManyToOne
    @field:JoinColumn(name = "id_prodi", referencedColumnName = "uuid", columnDefinition = "uuid")
    val idProdi : ProdiEntity? = null
)
