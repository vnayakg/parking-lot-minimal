import model.Ticket
import model.Vehicle
import java.util.Date

class ParkingLot {
    fun park(vehicle: Vehicle, date: Date): Ticket {
        return Ticket(1, vehicle, 1, date)
    }

}