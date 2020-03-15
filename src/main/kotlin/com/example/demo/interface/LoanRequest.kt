package com.example.demo.`interface`

import com.fasterxml.jackson.annotation.JsonProperty


class LoanRequest {

    @JsonProperty("client.id")
    private var clientId: String? = null

    private var loanAmount: Long? = null

    fun getClientId(): String? {
        return clientId
    }

    fun setClientId(clientId: String) {
        this.clientId = clientId
    }

    fun getLoanAmount(): Long? {
        return loanAmount
    }

    fun setLoanRequestAmount(loanAmount: Long?) {
        this.loanAmount = loanAmount
    }
}