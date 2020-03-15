package com.example.demo.`interface`

import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class FraudController {

    @PutMapping(value = ["/fraudcheck"], consumes = ["application/json"], produces = ["application/json"])
    fun check(@RequestBody loanRequest: LoanRequest): String {

        return if (loanRequest.getLoanAmount()?.let { it > 1000 } ?: false) {
            "{fraudCheckStatus: FRAUD, rejection.reason: Amount too high}"
        } else {
            "{fraudCheckStatus: OK, acceptance.reason: Amount OK}"
        }
    }
}