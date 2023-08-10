package com.techno.springboot.dasar.domain.entity

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "prodi")
data class ProdiEntity(
    @Id
    @field:Column(name ="uuid", columnDefinition = "uuid")
    val id : UUID? = null,
    @field:Column(name ="nama_prodi", columnDefinition = "varchar")
    val namaProdi : String? = null,
)
