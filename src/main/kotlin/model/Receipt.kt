package model

import java.util.*

class Receipt(
    private val receiptNumber: String,
    private val entryDateTime: Date,
    private val exitDateTime: Date,
    private val fee: Float
) {

    fun getFee(): Float {
        return fee
    }

    override fun toString(): String {
        return """
            Receipt
            Receipt Number: $receiptNumber
            Entry Date-time: $entryDateTime
            Exit Date-time: $exitDateTime
            Fees: $fee
            """.trimIndent()
    }
}