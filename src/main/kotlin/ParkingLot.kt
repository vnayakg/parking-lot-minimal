import model.*
import repository.ParkingSpotRepository
import java.util.Date
import java.util.UUID

class ParkingLot(
    private val parkingSpotRepository: ParkingSpotRepository,
    private val feeCalculator: FeeScheme
) {

    fun park(vehicle: Vehicle, currentDateTime: Date): Ticket {
        val vehicleType = vehicle.getVehicleType()

        val nextAvailableParkingSpot =
            parkingSpotRepository.getNextAvailableSpot(vehicleType)

        nextAvailableParkingSpot.allocateSlot(vehicle)

        return Ticket(
            UUID.randomUUID().toString(),
            vehicle,
            nextAvailableParkingSpot.getSpotNumber(),
            currentDateTime
        )
    }

    fun unPark(ticket: Ticket, exitDateTime: Date): Receipt {
        val spot = parkingSpotRepository.getSpotByVehicleNumber(
            ticket.getVehicleType(),
            ticket.getVehicleLicenseNumber()
        )

        spot.vacateSlot()

        val parkHours = calculateParkHours(ticket.getIssueDateTime(), exitDateTime)
        val parkingFee = feeCalculator.calculateFee(parkHours, ticket.getVehicleType())

        return Receipt(
            UUID.randomUUID().toString(),
            ticket.getIssueDateTime(),
            exitDateTime,
            parkingFee
        )
    }

    private fun calculateParkHours(issueDateTime: Date, exitDateTime: Date): Float {
        val timeDifferenceInMilliSeconds = exitDateTime.time - issueDateTime.time
        val milliSecondsPerHour = 1000f * 60f * 60f

        return timeDifferenceInMilliSeconds / milliSecondsPerHour
    }

}