package com.github.charlesluxinger.controller

import com.github.charlesluxinger.service.PasswordValidatorService
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PasswordValidatorControllerImpl(private val passwordService: PasswordValidatorService) :
    PasswordValidatorController {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping("/password", produces = [APPLICATION_JSON_VALUE], consumes = [APPLICATION_JSON_VALUE])
    override fun validator(@RequestBody request: PasswordValidatorRequest) =
        request
            .also { logger.info("Received password to check: ${it.password}") }
            .run { passwordService.isValid(this.password) }
            .let { PasswordValidatorResponse(it) }
}

@Tag(name = "Password Validator Request")
data class PasswordValidatorRequest(@Schema(example = "AbTp9!fok", required = true, minLength = 9) val password: String)

@Tag(name = "Password Validator Response")
data class PasswordValidatorResponse(@Schema(example = "true") val isValid: Boolean)