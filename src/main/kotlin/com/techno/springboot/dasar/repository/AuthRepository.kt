package com.techno.springboot.dasar.repository

import com.techno.springboot.dasar.domain.entity.TokenEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID


interface AuthRepository : JpaRepository<TokenEntity, String> {
    fun findIdByToken(token: String) : TokenEntity?
    fun findById(id: UUID) : TokenEntity?
}