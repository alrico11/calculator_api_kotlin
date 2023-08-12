package com.techno.springboot.dasar.domain.dto.request

import com.techno.springboot.dasar.domain.validation.CustomClassValidation
import com.techno.springboot.dasar.domain.validation.CustomFieldValidation
import org.hibernate.validator.constraints.UniqueElements
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

//@CustomClassValidation(message = "Invalid request user DTO")
data class ReqUserDto(
    @field:NotNull(message = "Field Name Mahasiswa Not Null")
    @field:NotEmpty(message = "Field Name Mahasiswa Not Empty")
    val name : String? = null,

    @field:NotNull(message = "Field Username Not Null")
    @field:NotEmpty(message = "Field Username Not Empty")
    @field:Size(max = 32, message = "Field length must be at most 32 character")
    @field:CustomFieldValidation(message = "Username is already taken")
    val username: String? = null,

    @field:NotNull(message = "Field email Not Null")
    @field:NotEmpty(message = "Field email Not Empty")
    @field:Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
    @field:CustomFieldValidation(message = "Email is already taken")
    val email: String? = null,

    @field:NotNull(message = "Field Password Not Null")
    @field:NotEmpty(message = "Field Password Not Empty")
    @field:Size(max = 32, message = "Field length must be at most 32 character")
    val password : String? = null,
)
