package com.techno.springboot.dasar.controller

import com.techno.springboot.dasar.domain.dto.request.ReqDecodeJwtDto
import com.techno.springboot.dasar.domain.dto.request.ReqExampleJwtDto
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto
import com.techno.springboot.dasar.domain.dto.response.ResDecodeJwtDto
import com.techno.springboot.dasar.domain.dto.response.ResExampleJwtDto
import com.techno.springboot.dasar.util.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@RestController
@RequestMapping("/v1/api/jwt")
class JwtController {

    @PostMapping("/encode")
    fun encode(@RequestBody reqExampleJwtDto: ReqExampleJwtDto): ResponseEntity<ResBaseDto<ResExampleJwtDto>> {
        val exp = 3600000L
        val token = JWTGenerator().createJWT(
            reqExampleJwtDto.id.toString(),
            reqExampleJwtDto.username!!,
            exp
        )
        val dataResponse = ResExampleJwtDto(
            token = token,
            id = reqExampleJwtDto.id
        )
        val response = ResBaseDto(data = dataResponse,code = 200)
        return ResponseEntity.ok().body(response)
    }
    @PostMapping("/decode")
    fun decode(@RequestBody reqDecodeJwtDto: ReqDecodeJwtDto): ResponseEntity<ResBaseDto<ResDecodeJwtDto>> {
        val claims = JWTGenerator().decodeJWT(reqDecodeJwtDto.token!!)
        val dataResponse = ResDecodeJwtDto(
            id = Integer.valueOf(AESUtils.decrypt(claims.id, secretKey="TECHNOSECRET")),
            username = AESUtils.decrypt(claims.subject,secretKey="TECHNOSECRET")
        )
        val response = ResBaseDto(
            data = dataResponse
        )
        return ResponseEntity.ok().body(response)
    }
}