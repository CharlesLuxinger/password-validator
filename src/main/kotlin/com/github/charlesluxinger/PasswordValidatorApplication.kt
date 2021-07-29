package com.github.charlesluxinger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PasswordValidatorApplication

fun main(args: Array<String>) {
    runApplication<PasswordValidatorApplication>(*args)
}
