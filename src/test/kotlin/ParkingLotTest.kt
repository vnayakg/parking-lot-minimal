import model.Vehicle
import model.VehicleType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class ParkingLotTest {
    @Test
    fun `it should park vehicle`() {
        val parkingLot = ParkingLot()
        val vehicle = Vehicle(VehicleType.CAR, "MH 12 AB 1234")
        val issueDateTime = Date()
        val ticket = parkingLot.park(vehicle, issueDateTime)

        assertEquals("MH 12 AB 1234", ticket.getVehicleLicenseNumber())
        assertEquals(issueDateTime, ticket.getIssueDateTime())
    }
}