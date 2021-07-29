package com.github.charlesluxinger.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "Password Validator")
interface PasswordValidatorController {

    @Operation(summary = "Password Validator", responses = [
        ApiResponse(responseCode = "200", description = "Return if a password is valid",
            content = [Content(schema = Schema(implementation = PasswordValidatorResponse::class))])
    ])
    @PostMapping("/password", produces = [APPLICATION_JSON_VALUE], consumes = [APPLICATION_JSON_VALUE])
    fun validator(
        @Parameter(description = "Password to check if is valid",
        required = true,
        schema = Schema(implementation = PasswordValidatorRequest::class, oneOf = [PasswordValidatorRequest::class]))
        @RequestBody request: PasswordValidatorRequest): PasswordValidatorResponse
}