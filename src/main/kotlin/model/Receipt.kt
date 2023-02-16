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
            Receipt\n
            Receipt Number: $receiptNumber\n
            Entry Date-time: $entryDateTime\n
            Exit Date-time: $exitDateTime\n
            Fees: $fee
            """.trimIndent()
    }
}