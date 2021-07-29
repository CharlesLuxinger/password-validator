package com.github.charlesluxinger.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.regex.Pattern

@Service
class PasswordValidatorServiceImpl : PasswordValidatorService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun isValid(password: String) =
        password.takeIf { it.hasNotRepeatChar() }
            ?.let {
                PasswordRegexRules.values()
                    .map { it.isValid(password).apply { logger.info("Is $it valid: $this") } }
                    .all { it }
            } ?: false
}

private fun String.hasNotRepeatChar() : Boolean {
    val chars = mutableSetOf<Int>()
    var isNotRepeated = true

    this.chars()
        .forEach {
            isNotRepeated = chars.contains(it).not()
            chars.add(it)
        }

    return isNotRepeated
}

private enum class PasswordRegexRules(private val regex: String) {

    NOT_BLANK_OR_SPACE("^\\S+\$"),
    MIN_LENGTH("^.{9,}\$"),
    NUMBER("[0-9]"),
    UPPER_CHAR("[A-Z]"),
    LOWER_CHAR("[a-z]"),
    ESPECIAL_CHAR("[!@#\$%^&*()\\-\\+]");

    fun isValid(password: String) = Pattern.compile(regex).matcher(password).find()

}