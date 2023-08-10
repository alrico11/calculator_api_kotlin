package com.techno.springboot.dasar.repository

import com.techno.springboot.dasar.domain.entity.MahasiswaEntity
import com.techno.springboot.dasar.domain.entity.ProdiEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional
import java.util.*

interface MahasiswaRepository : JpaRepository<MahasiswaEntity,String>{
    fun findByNim(nim: Long) : MahasiswaEntity?
    fun findById(id: Long) : MahasiswaEntity?

    @Modifying
    @Transactional
    @Query(value= "Delete MahasiswaEntity WHERE id = :id")
    fun deleteId(id: Long): Int?
}