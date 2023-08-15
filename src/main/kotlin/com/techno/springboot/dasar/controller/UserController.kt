package com.techno.springboot.dasar.controller

import com.techno.springboot.dasar.domain.dto.request.ReqUserDto
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto
import com.techno.springboot.dasar.domain.dto.response.ResUserDto
import com.techno.springboot.dasar.domain.validation.CustomClassValidation
import com.techno.springboot.dasar.domain.validation.validator.FieldValidator
import com.techno.springboot.dasar.exception.CustomExceptionHandler
import com.techno.springboot.dasar.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid

@RestController
@RequestMapping("/v1/api")

class UserController(
    private val userService: UserService,
    private val fieldValidator: FieldValidator
) {
    @GetMapping("/user")
    fun getAll(): ResponseEntity<ResBaseDto<ArrayList<ResUserDto>>> {
        val res = userService.getAll()
        return ResponseEntity.ok().body(res)
    }
    @GetMapping("/user/{uuid}")
    fun getById(@PathVariable("uuid") id : UUID): ResponseEntity<ResBaseDto<ResUserDto>> {
        val res = userService.getById(id)
        return ResponseEntity.ok().body(res)
    }
    @PostMapping("/user")
    fun insert(@Valid @RequestBody reqUserDto: ReqUserDto): ResponseEntity<ResBaseDto<Any>> {

        val response = userService.insert(reqUserDto)
        return ResponseEntity.ok().body(response)
    }
    @PutMapping("/user/{uuid}")
    fun update(@PathVariable("uuid")id : UUID, @RequestBody reqUserDto: ReqUserDto): ResponseEntity<ResBaseDto<Any>> {
        val res = userService.update(reqUserDto, id)
        return ResponseEntity.ok().body(res)
    }

    @DeleteMapping("/user/{uuid}")
    fun delete(@PathVariable("uuid")id : UUID): ResponseEntity<ResBaseDto<Any>> {
        val res = userService.delete(id)
        return ResponseEntity.ok().body(res)
    }
}