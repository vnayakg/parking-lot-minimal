import calculator.FeeScheme
import model.Receipt
import model.Ticket
import model.Vehicle
import repository.ParkingSpotList
import java.util.*

class ParkingLot(
    private val parkingSpotList: ParkingSpotList,
    private val feeCalculator: FeeScheme,
    private val idGenerator: IDGenerator
) {

    fun park(vehicle: Vehicle, currentDateTime: Date): Ticket {
        val vehicleType = vehicle.getVehicleType()

        val nextAvailableParkingSpot = parkingSpotList.getNextAvailableSpot(vehicleType)

        return Ticket(
            idGenerator.generateTicketID(),
            vehicle,
            nextAvailableParkingSpot,
            currentDateTime
        )
    }

    fun unPark(ticket: Ticket, exitDateTime: Date): Receipt {
        val spot = ticket.getAssignedSpot()

        parkingSpotList.vacateSpot(spot)

        val parkingFee = feeCalculator.calculateFee(
            ticket.getIssueDateTime(),
            exitDateTime,
            ticket.getVehicleType()
        )

        return Receipt(
            idGenerator.generateReceiptID(),
            ticket.getIssueDateTime(),
            exitDateTime,
            parkingFee
        )
    }

}