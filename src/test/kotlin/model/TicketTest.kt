package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class TicketTest {
    @Test
    fun `should get ticket information`() {
        val vehicle = Vehicle(VehicleType.CAR, "MH 12 AB 1234")
        val issueDateTime = Date()
        val spot = ParkingSpot(1, VehicleType.CAR, 1)

        val ticket = Ticket("ABC123", vehicle, spot, issueDateTime)
        val expectedTicketInformation = ticket.getTicketInformationString()

        val actualTicketInformation = """
            Ticket
            TicketNumber: ABC123
            Spot Number: 1
            Entry DateTime: $issueDateTime
        """.trimIndent()

        assertEquals(expectedTicketInformation, actualTicketInformation)
    }
}