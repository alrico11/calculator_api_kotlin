package com.techno.springboot.dasar.controller

import com.techno.springboot.dasar.domain.dto.request.ReqCalculator
import com.techno.springboot.dasar.domain.dto.request.ReqIdentitasDto
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto
import com.techno.springboot.dasar.domain.dto.response.ResCalculator
import com.techno.springboot.dasar.domain.dto.response.ResFullNameDto
import com.techno.springboot.dasar.domain.dto.response.ResIdentitasDto
import com.techno.springboot.dasar.service.LogicService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.xml.ws.Response

@RestController
@RequestMapping("/v1/api")
class TestController(
    private val logicService: LogicService
) {
    @Value("\${person.name.first}")
    val firstName = ""
    val lastName = "Wibowo"
    val log = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/test")
    fun testGetMapping(): ResponseEntity<LinkedHashMap<String, String>> {
        val response : LinkedHashMap<String,String> = LinkedHashMap()
        response["firstName"] = firstName
        response["lastName"] = lastName
        return ResponseEntity.ok(response)
    }

    @GetMapping("/get-age")
    fun getAge(@RequestParam("age") age : String): ResponseEntity<LinkedHashMap<String, String>>{
        val response : LinkedHashMap<String,String> = LinkedHashMap()
        response["firstName"] = firstName
        response["lastName"] = lastName
        response["age"] = age
        return ResponseEntity.ok(response)
    }

    @GetMapping("get-age/{age}")
    fun getAgeByPath(@PathVariable("age") age : String): ResponseEntity<LinkedHashMap<String, String>> {
        val response : LinkedHashMap<String,String> = LinkedHashMap()
        response["firstName"] = firstName
        response["lastName"] = lastName
        response["age"] = age
        return ResponseEntity.ok(response)
    }

    @PostMapping("/get-identitas")
    fun getIdentitas(@RequestBody reqIdentitasDto: ReqIdentitasDto): ResponseEntity<ResBaseDto<ResIdentitasDto>> {
        log.info("Incoming Request : $reqIdentitasDto")

        val response : LinkedHashMap<String,String> = LinkedHashMap()

        response["firstName"] = reqIdentitasDto.firstName.toString()
        response["lastName"] = reqIdentitasDto.lastName.toString()
        response["age"] = reqIdentitasDto.age.toString()


        val responseBody = ResIdentitasDto(
            firstName = reqIdentitasDto.firstName,
            lastName = reqIdentitasDto.lastName,
            age = reqIdentitasDto.age
        )
        val responseBase = ResBaseDto(status = true, message = "success", data = responseBody)
        return ResponseEntity.ok().body(responseBase)
    }

    @PostMapping("/get-fullname")
    fun getFullName(@RequestBody reqIdentitasDto: ReqIdentitasDto): ResponseEntity<ResBaseDto<ResFullNameDto>> {
        val response = logicService.fullName(reqIdentitasDto)
        return ResponseEntity.ok().body(response)
    }

    @PostMapping("/calculator/{operation}")
    fun getResult(@PathVariable("operation") operation: String, @RequestBody reqCalculator: ReqCalculator): ResponseEntity<ResBaseDto<ResCalculator>> {
        val response = logicService.calculator(operation, reqCalculator)
        return ResponseEntity.ok().body(response)
    }
}