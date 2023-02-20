package model

import java.util.*

class Ticket(
    private val ticketNumber: String,
    private val vehicle: Vehicle,
    private val assignedSpot: ParkingSpot,
    private val issueDateTime: Date,
) {

    fun getVehicleLicenseNumber(): String {
        return vehicle.getVehicleLicenseNumber()
    }

    fun getVehicleType(): VehicleType {
        return vehicle.getVehicleType()
    }

    fun getIssueDateTime(): Date {
        return issueDateTime
    }

    fun getAssignedSpot(): ParkingSpot {
        return assignedSpot
    }

    fun getTicketInformationString(): String {
        return """
            Ticket
            TicketNumber: $ticketNumber
            Floor Number: ${assignedSpot.getFloorNumber()}
            Spot Number: ${assignedSpot.getSpotNumber()}
            Entry DateTime: $issueDateTime
            """.trimIndent()
    }

}