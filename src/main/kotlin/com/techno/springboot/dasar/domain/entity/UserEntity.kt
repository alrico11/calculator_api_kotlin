package com.techno.springboot.dasar.domain.entity

import java.util.UUID
import javax.persistence.*
import com.techno.springboot.dasar.domain.validation.CustomFieldValidation

@Entity
@Table(name = "users")

data class UserEntity(
    @Id
    @field:Column(name = "uuid", columnDefinition = "uuid")
    val id: UUID? = null,

    @field:Column(name = "name", columnDefinition = "varchar")
    val name: String? = null,

    @field:Column(name = "username", unique = true, columnDefinition = "varchar")
    val username: String? = null,

    @field:Column(name = "email", columnDefinition = "varchar")
    val email: String? = null,

    @field:Column(name = "password", columnDefinition = "varchar")
    val password: String? = null
)
