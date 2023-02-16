package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class TicketTest {
    @Test
    fun `should get ticket information`() {
        val vehicle = Vehicle(VehicleType.CAR, "MH 12 AB 1234")
        val issueDateTime = Date()

        val ticket = Ticket("ABC123", vehicle, 1, issueDateTime)
        val expectedTicketInformation = ticket.toString()

        val actualTicketInformation = """
            ""${'"'}
            Ticket\n
            TicketNumber: ABC123\n
            Spot Number: 1\n
            Entry DateTime: $issueDateTime
            ""${'"'}
        """.trimIndent()

        assertEquals(expectedTicketInformation, actualTicketInformation)
    }
}