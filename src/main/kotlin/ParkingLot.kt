import calculator.FeeScheme
import model.Receipt
import model.Ticket
import model.Vehicle
import repository.ParkingFloorList
import java.util.*

class ParkingLot(
    private val parkingFloorList: ParkingFloorList,
    private val feeCalculator: FeeScheme,
    private val idGenerator: IDGenerator
) {

    fun park(vehicle: Vehicle, entryDateTime: Date): Ticket {
        val vehicleType = vehicle.getVehicleType()

        val availableFloor = parkingFloorList.getAvailableFloor()
        val nextAvailableParkingSpot = availableFloor.getNextAvailableSpot(vehicleType)

        return Ticket(
            idGenerator.generateTicketID(),
            vehicle,
            nextAvailableParkingSpot,
            entryDateTime
        )
    }

    fun unPark(ticket: Ticket, exitDateTime: Date): Receipt {
        val spot = ticket.getAssignedSpot()

        val floor = parkingFloorList.getFloorByFloorNumber(spot.getFloorNumber())
        floor.vacateSpot(spot)

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