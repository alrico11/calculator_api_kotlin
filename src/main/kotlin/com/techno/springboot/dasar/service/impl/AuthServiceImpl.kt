package com.techno.springboot.dasar.service.impl

import com.techno.springboot.dasar.domain.dto.request.ReqDecodeJwtDto
import com.techno.springboot.dasar.domain.dto.request.ReqLoginDto
import com.techno.springboot.dasar.domain.dto.request.ReqValidateUserDto
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto
import com.techno.springboot.dasar.domain.dto.response.ResDecodeJwtDto
import com.techno.springboot.dasar.domain.entity.TokenEntity
import com.techno.springboot.dasar.exception.CustomExceptionHandler
import com.techno.springboot.dasar.repository.AuthRepository
import com.techno.springboot.dasar.repository.UserRepository
import com.techno.springboot.dasar.service.AuthService
import com.techno.springboot.dasar.util.AESUtils
import com.techno.springboot.dasar.util.JWTGenerator
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

@Service
data class AuthServiceImpl(
    private val userRepository: UserRepository,
    private val authRepository: AuthRepository
) : AuthService{
    override fun login(reqLoginDto: ReqLoginDto): ResBaseDto<Any> {
        val data = userRepository.findByUsername(reqLoginDto.username.toString()) ?: throw CustomExceptionHandler("Username Not Found")
        if ( reqLoginDto.password != data.password)
            throw CustomExceptionHandler("Username or Password invalid")
        var expiredJwt = System.currentTimeMillis()+3600000L
        val expiredDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(expiredJwt),ZoneId.systemDefault())
        val token : String? = JWTGenerator().createJWT(
            reqLoginDto.username!!,
            reqLoginDto.password!!,
            expiredJwt
        )
        val dataEntity = TokenEntity(
            id = UUID.randomUUID(),
            token = token,
            exp = expiredDate,
            idUser = data,
        )
        authRepository.save(dataEntity)
        return ResBaseDto(data = mapOf("uuid" to data.id,"token" to token))
    }

    override fun validateUser(reqValidateUserDto: ReqValidateUserDto): ResBaseDto<Any> {
        val data = authRepository.findIdByToken(reqValidateUserDto.token.toString()) ?: throw CustomExceptionHandler("Token Not Found or Expired")
        val isTokenValid = validateToken(reqValidateUserDto.token.toString())
        println(data.exp)
            val userMap = mapOf(
                "id" to data.idUser?.id,
                "name" to data.idUser?.name,
                "username" to data.idUser?.username,
                "email" to data.idUser?.email
            )
            return ResBaseDto(data = userMap)
        }

    override fun validateToken(auth: String): Boolean {
        val data = authRepository.findIdByToken(auth) ?: throw CustomExceptionHandler("Token not valid")
        val dateTimeString = data.exp.toString()
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
        val dateTime = LocalDateTime.parse(dateTimeString, dateTimeFormatter)
        val currentTime = LocalDateTime.now()
        if (currentTime.isAfter(dateTime)) {
            throw CustomExceptionHandler("Token Mati")
        }
        return true
    }
}
