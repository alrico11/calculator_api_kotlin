package com.techno.springboot.dasar.service.impl

import com.techno.springboot.dasar.domain.dto.request.ReqUserDto
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto
import com.techno.springboot.dasar.domain.dto.response.ResUserDto
import com.techno.springboot.dasar.domain.entity.UserEntity
import com.techno.springboot.dasar.domain.validation.CustomFieldValidation
import com.techno.springboot.dasar.domain.validation.validator.FieldValidator
import com.techno.springboot.dasar.exception.CustomExceptionHandler
import com.techno.springboot.dasar.repository.UserRepository
import com.techno.springboot.dasar.service.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated
import java.util.*
@Service
@Validated
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val fieldValidator: FieldValidator
): UserService {
    override fun getAll(): ResBaseDto<ArrayList<ResUserDto>> {
        val data: MutableList<UserEntity> = userRepository.findAll()
        if (data.isEmpty())
            throw CustomExceptionHandler("Data Not Found")
        val res : ArrayList<ResUserDto> = ArrayList()
        data.forEach {
            res.add(
                ResUserDto(
                    id = it.id!!,
                    name = it.name!!,
                    username = it.username!!,
                    email = it.email!!,
                    password = it.password!!
                )
            )
        }
        return ResBaseDto(data = res)
    }

    override fun insert(reqUserDto: ReqUserDto): ResBaseDto<Any> {
        val uuid = UUID.randomUUID()
        val data = UserEntity(
            id = uuid,
            name = reqUserDto.name!!,
            username = reqUserDto.username!!,
            email = reqUserDto.email!!,
            password = reqUserDto.password!!
        )

        val entity = userRepository.save(data)
        val res = ResUserDto(
            id = entity.id,
            name = entity.name,
            username = entity.username,
            email = entity.email,
            password = entity.password,
        )
        return ResBaseDto(data = res)
    }

    override fun getById(id: UUID): ResBaseDto<ResUserDto>
    {
        val data = userRepository.findById(id)
        if (data == null)
            throw CustomExceptionHandler("Data Not Found")
        val res = ResUserDto(
            id = data.id!!,
            name = data.name!!,
            username = data.username!!,
            email = data.email!!,
            password = data.password!!
        )
        return ResBaseDto(data = res)
    }

    override fun update(reqUserDto: ReqUserDto, id: UUID): ResBaseDto<Any> {
        val data = userRepository.findById(id)
        if (data == null)
            throw CustomExceptionHandler("Data Not Found")
        val newData = data.copy(
            name = reqUserDto.name,
            username = reqUserDto.username,
            email = reqUserDto.email,
            password = reqUserDto.password,
        )
        val entity = userRepository.save(newData)
        val response = ResUserDto(
            name = entity.name!!,
            username = entity.username!!,
            email = entity.username!!,
            password = entity.password!!,
        )
        return ResBaseDto(data = response)
    }

    override fun delete(id: UUID): ResBaseDto<Any> {
        userRepository.deleteById(id)
        return ResBaseDto(data = null)
    }

}