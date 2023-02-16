package model

import java.util.*

class Receipt(
    private val id: Int,
    private val vehicleNumber: String,
    private val entryDateTime: Date,
    private val exitDateTime: Date,
    private val fee: Float
) {

    fun getReceiptId(): Int {
        return id
    }

    fun getFee(): Float {
        return fee
    }

    fun getVehicleNumber(): String {
        return vehicleNumber
    }

    override fun toString(): String {
        return """
            Receipt\n
            Receipt Number: $id\n
            Entry Date-time: $entryDateTime\n
            Exit Date-time: $exitDateTime\n
            Fees: $fee
            """.trimIndent()
    }
}