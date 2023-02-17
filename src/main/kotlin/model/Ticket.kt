package model

import java.util.*

class Ticket(
    private val ticketNumber: String,
    private val vehicle: Vehicle,
    private val spotNumber: Int,
    private val issueDateTime: Date,
) {
    override fun toString(): String {
        return """
            Ticket
            TicketNumber: $ticketNumber
            Spot Number: $spotNumber
            Entry DateTime: $issueDateTime
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

}