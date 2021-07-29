package com.github.charlesluxinger.controller

import io.restassured.RestAssured
import io.restassured.RestAssured.given
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@SpringBootTest(webEnvironment = RANDOM_PORT)
internal class PasswordValidatorControllerImplTest {

    @LocalServerPort
    private val port = 0

    @BeforeEach
    fun setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
        RestAssured.basePath = "/api/v1/password"
        RestAssured.port = port
    }

    @Test
    @DisplayName("When is a valid password should return true")
    fun whenIsAValidPasswordShouldReturnTrue() {
        assert("AbTp9!fok", true)
    }

    @Test
    @DisplayName("When password is blank should return false")
    fun whenPasswordIsBlankShouldReturnFalse() {
        assert("", false)
    }

    @Test
    @DisplayName("When password contains repeated char should return false")
    fun whenPasswordContainsRepeatedCharReturnFalse() {
        assert("AbTp9!fokA", false)
    }

    @Test
    @DisplayName("When password contains less than 9 char should return false")
    fun whenPasswordContainsLessThanNineCharReturnFalse() {
        assert("AbTp9!fo", false)
    }

    @Test
    @DisplayName("When password not contains a digit should return false")
    fun whenPasswordNotContainsADigitReturnFalse() {
        assert("AbTpÇ!fok", false)
    }

    @Test
    @DisplayName("When password not contains an upper char should return false")
    fun whenPasswordNotContainsAnUpperCharReturnFalse() {
        assert("abtp9!fok", false)
    }

    @Test
    @DisplayName("When password not contains an lower char should return false")
    fun whenPasswordNotContainsAnLowerCharReturnFalse() {
        assert("ABTP9!FOK", false)
    }

    @Test
    @DisplayName("When password not contains a special char should return false")
    fun whenPasswordNotContainsASpecialCharReturnFalse() {
        assert("AbTp9zfok", false)
    }

    @Test
    @DisplayName("When password contains space char should return false")
    fun whenPasswordContainsSpaceCharReturnFalse() {
        assert("AbTp9 fok", false)
    }

    private fun assert(password: String, valid: Boolean) {
        given()
            .contentType(APPLICATION_JSON_VALUE)
            .body(PasswordValidatorRequest(password))
        .expect()
            .statusCode(200)
        .`when`()
            .post()
        .then()
            .contentType(APPLICATION_JSON_VALUE)
            .body("isValid", `is`(valid))
    }
}