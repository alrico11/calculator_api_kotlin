package com.techno.springboot.dasar.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.techno.springboot.dasar.domain.dto.response.ResBaseDto
import com.techno.springboot.dasar.exception.CustomExceptionHandler
import com.techno.springboot.dasar.repository.AuthRepository
import com.techno.springboot.dasar.service.AuthService
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class RequestInterceptor(
    private val authRepository: AuthRepository,
    private val authService: AuthService
):HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val apiKey = request.getHeader("api-key")
        val auth = request.getHeader("authorization")
        val data = authRepository.findIdByToken(auth) ?: throw CustomExceptionHandler("Token not valid")
        val isTokenValid = authService.validateToken(auth)

        if (apiKey != "123-456-789" || auth != data.token){
            val objectMapper = ObjectMapper()
            val result = objectMapper.writeValueAsString(ResBaseDto(false, "Failed", null, 403, "Forbidden"))
            response.writer.write(result)
            response.contentType = "application/json"
            response.characterEncoding = "UTF-8"
            response.status = 403
            return false
        }
        return true
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {

    }
}