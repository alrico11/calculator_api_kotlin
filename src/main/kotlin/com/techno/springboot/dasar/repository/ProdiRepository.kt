package com.techno.springboot.dasar.repository

import com.techno.springboot.dasar.domain.entity.MahasiswaEntity
import com.techno.springboot.dasar.domain.entity.ProdiEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID
import javax.persistence.Id

interface ProdiRepository : JpaRepository <ProdiEntity, String> {
    fun findById(id: UUID): ProdiEntity?
}