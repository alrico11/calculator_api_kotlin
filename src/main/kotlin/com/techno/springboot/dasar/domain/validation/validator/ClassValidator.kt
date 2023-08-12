
package com.techno.springboot.dasar.domain.validation.validator

import com.techno.springboot.dasar.domain.dto.request.ReqUserDto
import com.techno.springboot.dasar.domain.validation.CustomClassValidation
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ClassValidator : ConstraintValidator<CustomClassValidation, ReqUserDto> {
    override fun isValid(value: ReqUserDto?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) {
            return false
        }
        return !value.name.isNullOrEmpty() && !value.username.isNullOrEmpty() && !value.email.isNullOrEmpty() && !value.password.isNullOrEmpty()
    }
}