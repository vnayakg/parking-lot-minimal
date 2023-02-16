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
            1,
            "MH 12 AB 1234",
            entryDateTime,
            exitDateTime,
            10.0F
        )
        val actualReceiptOutput = receipt.toString()
        val expectedReceiptOutput =
            """
            Receipt\n
            Receipt Number: 1\n
            Entry Date-time: $entryDateTime\n
            Exit Date-time: $exitDateTime\n
            Fees: 10.0
            """.trimIndent()

        assertEquals(expectedReceiptOutput, actualReceiptOutput)


    }
}