package com.github.charlesluxinger.service

interface PasswordValidatorService {

    fun isValid(password: String): Boolean

}
