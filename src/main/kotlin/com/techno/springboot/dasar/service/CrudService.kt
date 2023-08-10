package com.techno.springboot.dasar.service

import com.techno.springboot.dasar.domain.dto.request.ReqMahasiswaDto
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto
import com.techno.springboot.dasar.domain.dto.response.ResMahasiswaDto

interface CrudService {
    fun getAll() : ResBaseDto<ArrayList<ResMahasiswaDto>>
    fun getById(id : Long) : ResBaseDto<ResMahasiswaDto>
    fun insert(reqMahasiswaDto: ReqMahasiswaDto) : ResBaseDto<Any>
    fun update(reqMahasiswaDto: ReqMahasiswaDto, id: Long) : ResBaseDto<Any>
    fun delete(id : Long) : ResBaseDto<Any>
    fun insertProdi(nama: String): ResBaseDto<Any>
}