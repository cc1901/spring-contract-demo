package com.example.demo

import com.example.demo.`interface`.FraudController
import io.restassured.module.mockmvc.RestAssuredMockMvc.given
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import wiremock.com.jayway.jsonpath.JsonPath


@WebMvcTest(value = [FraudController::class])
open class DemoApplicationTests {

	@Autowired
	lateinit var mvc: MockMvc;

	@Test
	fun validate_shouldMarkClientAsFraud() {
		// given:
		val request = given().mockMvc(mvc)
				.header("Content-Type", "application/json")
				.body("{\"client.id\":\"1234567890\",\"loanAmount\":99999}")

		// when:
		val response = given().mockMvc(mvc).spec(request).put("/fraudcheck")

		// then:
		assertThat(response.statusCode()).isEqualTo(200)
		assertThat(response.header("Content-Type")).matches("application/json")
		// and:
		val parsedJson = JsonPath.parse(response.getBody().asString())
	}

}
