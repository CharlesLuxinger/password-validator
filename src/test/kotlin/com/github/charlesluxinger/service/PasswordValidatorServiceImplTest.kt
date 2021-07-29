package com.github.charlesluxinger.service

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PasswordValidatorServiceImplTest {

    private val passwordValidatorService = PasswordValidatorServiceImpl()

    @Test
    @DisplayName("When is a valid password should return true")
    fun whenIsAValidPasswordShouldReturnTrue() {
        assertTrue(passwordValidatorService.isValid("AbTp9!fok"))
    }

    @Test
    @DisplayName("When password is blank should return false")
    fun whenPasswordIsBlankShouldReturnFalse() {
        assertFalse(passwordValidatorService.isValid(""))
    }

    @Test
    @DisplayName("When password contains repeated char should return false")
    fun whenPasswordContainsRepeatedCharReturnFalse() {
        assertFalse(passwordValidatorService.isValid("AbTp9!foA"))
    }

    @Test
    @DisplayName("When password contains less than 9 char should return false")
    fun whenPasswordContainsLessThanNineCharReturnFalse() {
        assertFalse(passwordValidatorService.isValid("AbTp9!fo"))
    }

    @Test
    @DisplayName("When password not contains a digit should return false")
    fun whenPasswordNotContainsADigitReturnFalse() {
        assertFalse(passwordValidatorService.isValid("AbTpÇ!fok"))
    }

    @Test
    @DisplayName("When password not contains an upper char should return false")
    fun whenPasswordNotContainsAnUpperCharReturnFalse() {
        assertFalse(passwordValidatorService.isValid("abtp9!fok"))
    }

    @Test
    @DisplayName("When password not contains an lower char should return false")
    fun whenPasswordNotContainsAnLowerCharReturnFalse() {
        assertFalse(passwordValidatorService.isValid("ABTP9!FOK"))
    }

    @Test
    @DisplayName("When password not contains a special char should return false")
    fun whenPasswordNotContainsASpecialCharReturnFalse() {
        assertFalse(passwordValidatorService.isValid("AbTp9zfok"))
    }

    @Test
    @DisplayName("When password contains space char should return false")
    fun whenPasswordContainsSpaceCharReturnFalse() {
        assertFalse(passwordValidatorService.isValid("AbTp9 fok"))
    }
}