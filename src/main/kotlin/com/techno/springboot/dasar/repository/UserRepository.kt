package com.techno.springboot.dasar.repository

import com.techno.springboot.dasar.domain.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*
@Repository
interface UserRepository : JpaRepository<UserEntity, String>{
    fun findByEmail(email: String): UserEntity?
    fun findById(id: UUID): UserEntity?
    @Transactional
    fun deleteById(id: UUID)
}