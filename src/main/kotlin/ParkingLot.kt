import model.Ticket
import model.Vehicle
import java.util.Date

class ParkingLot(private val parkingSpotRepository: ParkingSpotRepository) {

    private var ticketNumber = 0
    fun park(vehicle: Vehicle, currentDateTime: Date): Ticket {
        val vehicleType = vehicle.getVehicleType()

        val nextAvailableParkingSpot =
            parkingSpotRepository.getNextAvailableSpot(vehicleType)

        nextAvailableParkingSpot.allocateSlot(vehicle)

        return Ticket(
            ++ticketNumber,
            vehicle,
            nextAvailableParkingSpot.getSpotNumber(),
            currentDateTime
        )
    }

}