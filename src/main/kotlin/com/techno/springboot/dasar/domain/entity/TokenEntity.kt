package com.techno.springboot.dasar.domain.entity

import java.sql.Date
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "token")

data class TokenEntity(
    @Id
    @field:Column(name = "uuid", columnDefinition = "uuid")
    val id: UUID? = null,

    @field:Column(name = "token", columnDefinition = "varchar")
    val token: String? = null,

    @field:Column(name = "expired_token", columnDefinition = "timestamp")
    val exp: LocalDateTime? = null,

    @ManyToOne
    @field:JoinColumn(name = "id_user", referencedColumnName = "uuid", columnDefinition = "uuid")
    val idUser: UserEntity? = null,
)