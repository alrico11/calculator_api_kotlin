package com.techno.springboot.dasar.controller

import com.techno.springboot.dasar.domain.dto.request.ReqLoginDto
import com.techno.springboot.dasar.domain.dto.request.ReqValidateUserDto
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto
import com.techno.springboot.dasar.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/v1/api/")
class AuthController(
   private val authService: AuthService
) {
    @PostMapping("/login")
    fun loginUser(@Valid @RequestBody reqLoginDto: ReqLoginDto): ResponseEntity<ResBaseDto<Any>> {
        val response = authService.login(reqLoginDto)

        return ResponseEntity.ok().body(response)
    }

    @PostMapping("/validate")
    fun validateUser(@RequestBody reqValidateUserDto: ReqValidateUserDto): ResponseEntity<ResBaseDto<Any>> {
        val response = authService.validateUser(reqValidateUserDto)
        return ResponseEntity.ok().body(response)
    }
}