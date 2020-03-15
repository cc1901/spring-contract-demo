package com.example.demo.contractTest

import com.example.demo.`interface`.FraudController
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.jupiter.api.BeforeEach


open class BaseTestClass {

    @BeforeEach
    fun setup() {
        RestAssuredMockMvc.standaloneSetup(FraudController())
    }
}