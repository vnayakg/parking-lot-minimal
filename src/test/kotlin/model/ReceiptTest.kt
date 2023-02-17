package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class ReceiptTest {
    @Test
    fun `it should generate receipt output`() {
        val entryDateTime = Date()
        val milliSecondsInHour = 360000
        val exitDateTime = Date(entryDateTime.time + milliSecondsInHour)

        val receipt = Receipt(
            "ABC123",
            entryDateTime,
            exitDateTime,
            10.0F
        )
        val actualReceiptOutput = receipt.toString()
        val expectedReceiptOutput =
            """
            Receipt
            Receipt Number: ABC123
            Entry Date-time: $entryDateTime
            Exit Date-time: $exitDateTime
            Fees: 10.0
            """.trimIndent()

        assertEquals(expectedReceiptOutput, actualReceiptOutput)


    }
}