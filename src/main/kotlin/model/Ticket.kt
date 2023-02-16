package model

import java.util.*

class Ticket(
    private val ticketNumber: Int,
    private val vehicle: Vehicle,
    private val spotNumber: Int,
    private val issueDateTime: Date,
) {
    override fun toString(): String {
        return """
            ""${'"'}
            Ticket\n
            TicketNumber: $ticketNumber\n
            Spot Number: $spotNumber\n
            Entry DateTime: $issueDateTime
            ""${'"'}
            """.trimIndent()
    }

    fun getVehicleLicenseNumber(): String {
        return vehicle.getVehicleLicenseNumber()
    }

    fun getVehicleType(): VehicleType {
        return vehicle.getVehicleType()
    }

    fun getIssueDateTime(): Date {
        return issueDateTime
    }

    fun getSpotNumber(): Int {
        return spotNumber
    }
}