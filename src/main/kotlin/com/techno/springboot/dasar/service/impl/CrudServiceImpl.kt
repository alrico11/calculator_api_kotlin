package com.techno.springboot.dasar.service.impl

import com.techno.springboot.dasar.domain.dto.request.ReqMahasiswaDto
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto
import com.techno.springboot.dasar.domain.dto.response.ResMahasiswaDto
import com.techno.springboot.dasar.domain.entity.MahasiswaEntity
import com.techno.springboot.dasar.domain.entity.ProdiEntity
import com.techno.springboot.dasar.exception.CustomExceptionHandler
import com.techno.springboot.dasar.repository.MahasiswaRepository
import com.techno.springboot.dasar.repository.ProdiRepository
import com.techno.springboot.dasar.service.CrudService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CrudServiceImpl(
    private val mahasiswaRepository: MahasiswaRepository,
    private val prodiRepository: ProdiRepository,
) : CrudService {
    override fun getAll(): ResBaseDto<ArrayList<ResMahasiswaDto>> {
        val data: MutableList<MahasiswaEntity> = mahasiswaRepository.findAll()
        if (data.isEmpty())
            throw CustomExceptionHandler("Data Not Found")
        val response : ArrayList<ResMahasiswaDto> = ArrayList()
        data.forEach{
            response.add(
                ResMahasiswaDto(
                    nim = it.nim!!,
                    nama = it.nama!!,
                    gender = it.gender!!,
                    alamat = it.alamat!!,
                    jurusan = it.idProdi!!.namaProdi!!
                )
            )
        }
        return ResBaseDto(data = response)
    }
    override fun getById(id: Long): ResBaseDto<ResMahasiswaDto>{
        val data = mahasiswaRepository.findById(id)
        if (data == null)
            throw CustomExceptionHandler("Data Not Found")
        val response = ResMahasiswaDto(
            nim = data.nim!!,
            nama = data.nama!!,
            gender = data.gender!!,
            alamat = data.alamat!!,
            jurusan = data.idProdi!!.namaProdi!!
        )
        return ResBaseDto(data = response)
    }
    override fun insert(reqMahasiswaDto: ReqMahasiswaDto): ResBaseDto<Any> {
        val prodiEntity = prodiRepository.findById(UUID.fromString(reqMahasiswaDto.idProdi)) ?: throw CustomExceptionHandler("ID Prodi Not Found")
        val data = MahasiswaEntity(
            nim = reqMahasiswaDto.nim,
            nama = reqMahasiswaDto.nama,
            gender = reqMahasiswaDto.gender,
            alamat = reqMahasiswaDto.alamat,
            idProdi = prodiEntity
        )
        val entity = mahasiswaRepository.save(data)
        val response = ResMahasiswaDto(
            nim = entity.nim!!,
            nama = entity.nama!!,
            gender = entity.gender!!,
            alamat = entity.alamat!!,
            jurusan = entity.idProdi!!.namaProdi!!
        )
        return ResBaseDto(data = response)
    }

    override fun update(reqMahasiswaDto: ReqMahasiswaDto, id: Long): ResBaseDto<Any> {
        val data = mahasiswaRepository.findById(id) ?: throw CustomExceptionHandler("ID Prodi Not Found")
        val prodiEntity = prodiRepository.findById(UUID.fromString(reqMahasiswaDto.idProdi.toString())) ?: return ResBaseDto(false, "Data not Found", null)
        val newData = data.copy(
            nim = reqMahasiswaDto.nim,
            nama = reqMahasiswaDto.nama,
            gender = reqMahasiswaDto.gender,
            alamat = reqMahasiswaDto.alamat,
            idProdi = prodiEntity
        )
        val entity = mahasiswaRepository.save(newData)
        val response = ResMahasiswaDto(
            nim = entity.nim!!,
            nama = entity.nama!!,
            gender = entity.gender!!,
            alamat = entity.alamat!!,
            jurusan = entity.idProdi!!.namaProdi!!
        )
        return ResBaseDto(data = response)
    }

    override fun delete(id: Long): ResBaseDto<Any> {
        mahasiswaRepository.deleteId(id)
        return ResBaseDto(data = null)
    }

    override fun insertProdi(nama: String): ResBaseDto<Any> {
        val uuid = UUID.randomUUID()
        prodiRepository.save(
            ProdiEntity(
                id = uuid,
                namaProdi = nama
            )
        )
        return ResBaseDto(data =  "Success")
    }
}