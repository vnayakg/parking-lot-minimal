import model.*
import repository.ParkingSpotList
import service.FeeScheme
import java.util.Date
import java.util.UUID

class ParkingLot(
    private val parkingSpotList: ParkingSpotList,
    private val feeCalculator: FeeScheme
) {

    fun park(vehicle: Vehicle, currentDateTime: Date): Ticket {
        val vehicleType = vehicle.getVehicleType()

        val nextAvailableParkingSpot = parkingSpotList.getNextAvailableSpot(vehicleType)

        nextAvailableParkingSpot.allocateSlot(vehicle)

        return Ticket(
            UUID.randomUUID().toString(),
            vehicle,
            nextAvailableParkingSpot,
            currentDateTime
        )
    }

    fun unPark(ticket: Ticket, exitDateTime: Date): Receipt {
        val spot = parkingSpotList.getSpotByVehicleNumber(
            ticket.getVehicleLicenseNumber()
        )

        spot.vacateSlot()

        val parkingFee = feeCalculator.calculateFee(
            ticket.getIssueDateTime(),
            exitDateTime,
            ticket.getVehicleType()
        )

        return Receipt(
            UUID.randomUUID().toString(),
            ticket.getIssueDateTime(),
            exitDateTime,
            parkingFee
        )
    }

}